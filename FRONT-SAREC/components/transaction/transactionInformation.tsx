import React, { useEffect, useMemo, useState } from 'react';
import {
  Card,
  CardBody,
  CardFooter,
  CardHeader,
  Divider,
  Pagination,
  Table,
  TableBody,
  TableCell,
  TableColumn,
  TableHeader,
  TableRow,
} from '@nextui-org/react';
import { useSession } from 'next-auth/react';

const fetchData = async (url: string, options?: RequestInit) => {
  const response = await fetch(url, options);
  if (!response.ok) {
    throw new Error(`HTTP error! Status: ${response.status}`);
  }
  return response.json();
};

const TransactionInformation: React.FC = () => {
  const { data: session, status } = useSession();
  const [page, setPage] = useState(1);
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const rowsPerPage = 3;

  const fetchDataForUser = async () => {
    try {
      setLoading(true);
      const transactions = await fetchData(
        `${process.env.NEXT_PUBLIC_BACKEND_URL}/transaction/get/all-by-user?userEmail=${session?.user?.email}`,
        {
          method: 'GET',
          headers: { 'Content-Type': 'application/json' },
        },
      );
      console.log('Transactions:', transactions[0]);
      setData(transactions);
    } catch (error) {
      console.error('Error fetching data:', error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchDataForUser();
  }, [status]);

  const items = useMemo(() => {
    const start = (page - 1) * rowsPerPage;
    const end = start + rowsPerPage;
    return data.slice(start, end);
  }, [page, data]);

  const getFormatDate = (time: string) => {
    const date = new Date(time);
    return date.toISOString().slice(0, 10);
  };

  return (
    <div className="dashBoardContainer w-full max-w-screen-sm">
      <Card className="max-w-screen-sm">
        <CardHeader className="flex gap-3">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth="1.5"
            stroke="currentColor"
            className="w-6 h-6"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M8.25 6.75h12M8.25 12h12m-12 5.25h12M3.75 6.75h.007v.008H3.75V6.75zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0zM3.75 12h.007v.008H3.75V12zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0zm-.375 5.25h.007v.008H3.75v-.008zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z"
            />
          </svg>
          <div className="flex flex-col">
            <p className="text-md">LISTA DE TRANSACCIONES</p>
          </div>
        </CardHeader>
        <Divider />
        <CardBody>
          <Table
            aria-label="Example table with client side pagination"
            bottomContent={
              <div className="flex w-full justify-center">
                <Pagination
                  isCompact
                  showControls
                  showShadow
                  color="primary"
                  page={page}
                  total={Math.ceil(data.length / rowsPerPage)}
                  onChange={(page) => setPage(page)}
                />
              </div>
            }
            classNames={{
              wrapper: 'min-h-[222px]',
            }}
          >
            <TableHeader>
              <TableColumn key="name">FECHA</TableColumn>
              <TableColumn key="role">CANTIDAD</TableColumn>
              <TableColumn key="status">ESTADO</TableColumn>
            </TableHeader>
            <TableBody items={items}>
              {(item) => (
                <TableRow key={(item as any).uuid}>
                  <TableCell>
                    {getFormatDate((item as any).timestamp)}
                  </TableCell>
                  <TableCell>{(item as any).amount}</TableCell>
                  <TableCell>
                    {(item as any).statePol == 4 ? (
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="green"
                        className="w-6 h-6"
                      >
                        <path
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          d="M9 12.75L11.25 15 15 9.75M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
                        />
                      </svg>
                    ) : (
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="red"
                        className="w-6 h-6"
                      >
                        <path
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          d="M9.75 9.75l4.5 4.5m0-4.5l-4.5 4.5M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
                        />
                      </svg>
                    )}
                  </TableCell>
                </TableRow>
              )}
            </TableBody>
          </Table>
        </CardBody>
      </Card>
    </div>
  );
};

export default TransactionInformation;
