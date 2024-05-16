import {
  Card,
  CardBody,
  CardFooter,
  CardHeader,
  Divider,
} from '@nextui-org/react';
import React, { useState, useEffect } from 'react';
import { PayuPrepayment } from '../payu-prepayment';
import { useSession } from 'next-auth/react';

const fetchData = async (url: string, options?: RequestInit) => {
  const response = await fetch(url, options);
  if (!response.ok) {
    throw new Error(`HTTP error! Status: ${response.status}`);
  }
  return response.json();
};

const Recharge = () => {
  const { data: session, status } = useSession();
  const [data, setData] = useState([]);
  const fetchDataForUser = async () => {
    try {
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
    }
  };

  useEffect(() => {
    fetchDataForUser();
  }, [status]);

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
              d="M2.25 8.25h19.5M2.25 9h19.5m-16.5 5.25h6m-6 2.25h3m-3.75 3h15a2.25 2.25 0 002.25-2.25V6.75A2.25 2.25 0 0019.5 4.5h-15a2.25 2.25 0 00-2.25 2.25v10.5A2.25 2.25 0 004.5 19.5z"
            />
          </svg>

          <div className="flex flex-col">
            <p className="text-md">SALDO PREPAGO</p>
          </div>
        </CardHeader>
        <Divider />
        <CardBody>
          <p>${(data[0] as any)?.user?.balance}</p>
        </CardBody>
        <Divider />
        <CardFooter>
          <PayuPrepayment />
        </CardFooter>
      </Card>
    </div>
  );
};

export default Recharge;
