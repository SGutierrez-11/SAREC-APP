import React, { useEffect, useState } from 'react';
import { Accordion, AccordionItem } from '@nextui-org/react';
import { FaMotorcycle } from 'react-icons/fa6';
import { FaTruckMoving } from 'react-icons/fa';
import { FaCarSide } from 'react-icons/fa';
import { useSession } from 'next-auth/react';

const fetchData = async (url: string, options?: RequestInit) => {
  const response = await fetch(url, options);
  if (!response.ok) {
    throw new Error(`HTTP error! Status: ${response.status}`);
  }
  return response.json();
};

const VehicleData = () => {
  const { data: session, status } = useSession();
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);

  const getData = async () => {
    try {
      setLoading(true);
      const vehicles = await fetchData(
        `${process.env.NEXT_PUBLIC_BACKEND_URL}/vehicle/get/all-by-user?userEmail=${session?.user?.email}`,
        {
          method: 'GET',
          headers: { 'Content-Type': 'application/json' },
        },
      );
      console.log('Vehicles:', vehicles[0]);
      setData(vehicles);
    } catch (error) {
      console.error('Error fetching data:', error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    getData();
  }, [status]);

  const defaultContent =
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.';

  return (
    <Accordion selectionMode="multiple">
      {data.map((vehicle) => (
        <AccordionItem
          key={(vehicle as any)?.plate}
          aria-label="Chung Miller"
          startContent={
            (vehicle as any)?.category == 'LIGERO' ? (
              <FaCarSide size={32} />
            ) : (vehicle as any)?.category == 'PESADO' ? (
              <FaTruckMoving size={32} />
            ) : (
              <FaMotorcycle size={32} />
            )
          }
          subtitle={`Placa: ${(vehicle as any)?.plate}`}
          title={(vehicle as any)?.vehicleClass}
        >
          <div className="grid grid-cols-2 gap-2">
            <p>{`Propetario: ${(vehicle as any)?.user?.name}`}</p>
            <p>{`Ejes: ${(vehicle as any)?.axiesAmount}`}</p>
            <p>{`Tipo de servicio: ${(vehicle as any)?.serviceType}`}</p>
          </div>
        </AccordionItem>
      ))}
    </Accordion>
  );
};

export default VehicleData;
