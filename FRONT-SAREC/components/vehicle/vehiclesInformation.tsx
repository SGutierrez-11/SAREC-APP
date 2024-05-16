import {
  Card,
  CardBody,
  CardFooter,
  CardHeader,
  Divider,
} from '@nextui-org/react';
import React from 'react';
import { GiSteeringWheel } from 'react-icons/gi';
import CreateVehicle from './createVehicle';
import VehicleData from './vehicleData';

const Vehicles = () => {
  return (
    <div className="dashBoardContainer w-full max-w-screen-sm">
      <Card className="max-w-screen-sm">
        <CardHeader className="flex gap-3">
          <GiSteeringWheel size={24} />
          <div className="flex flex-col">
            <p className="text-md">VEHICULOS</p>
          </div>
        </CardHeader>
        <Divider />
        <CardBody>
          <VehicleData />
        </CardBody>
        <Divider />
        <CardFooter>
          <CreateVehicle />
        </CardFooter>
      </Card>
    </div>
  );
};

export default Vehicles;
