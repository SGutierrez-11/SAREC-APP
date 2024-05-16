import {
  Card,
  CardHeader,
  Divider,
  CardBody,
  Table,
  Pagination,
  TableHeader,
  TableColumn,
  TableBody,
  TableRow,
  TableCell,
} from '@nextui-org/react';
import { data } from 'autoprefixer';
import { useSession } from 'next-auth/react';
import React, { useEffect, useMemo, useState } from 'react';
import { FaLocationDot } from 'react-icons/fa6';

const fetchData = async (url: string, options?: RequestInit) => {
  const response = await fetch(url, options);
  if (!response.ok) {
    throw new Error(`HTTP error! Status: ${response.status}`);
  }
  return response.json();
};

const RecordsInformation = () => {
  const { data: session, status } = useSession();
  const [page, setPage] = useState(1);
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const rowsPerPage = 2;

  const fetchDataForUser = async () => {
    try {
      setLoading(true);
      const record = await fetchData(
        `${process.env.NEXT_PUBLIC_BACKEND_URL}/record/get/all-by-user?userEmail=${session?.user?.email}`,
        {
          method: 'GET',
          headers: { 'Content-Type': 'application/json' },
        },
      );
      console.log('Records:', record);
      setData(record);
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
    return `${date.toISOString().slice(0, 10)} ${date
      .toISOString()
      .slice(11, 16)}`;
  };
  return (
    <div className="dashBoardContainer w-full max-w-screen-sm">
      <Card className="max-w-screen-sm">
        <CardHeader className="flex gap-3">
          <FaLocationDot size={24} />
          <div className="flex flex-col">
            <p className="text-md">PASO POR PEAJES</p>
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
              <TableColumn key="name">VEHICULO</TableColumn>
              <TableColumn key="role">PEAJE</TableColumn>
              <TableColumn key="status">FECHA Y HORA</TableColumn>
            </TableHeader>
            <TableBody items={items}>
              {(item) => (
                <TableRow key={(item as any)?.uuid}>
                  <TableCell>{(item as any)?.vehicle?.plate}</TableCell>
                  <TableCell>{(item as any)?.toll?.name}</TableCell>
                  <TableCell>
                    {getFormatDate((item as any)?.timestamp)}
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

export default RecordsInformation;
