import React, { useEffect, useState } from 'react';
import {
  Modal,
  ModalContent,
  ModalHeader,
  ModalBody,
  ModalFooter,
  Button,
  useDisclosure,
  Input,
} from '@nextui-org/react';
import { Select, SelectItem } from '@nextui-org/react';
import { useSession } from 'next-auth/react';

const CreateVehicle = () => {
  const { data: session, status } = useSession();
  const { isOpen, onOpen, onOpenChange } = useDisclosure();
  const [selectOption, setSelectOption] = useState('');
  const [selectCategory, setSelectCategory] = useState('');
  const [plate, setPlate] = useState('');
  const [serviceType, setServiceType] = useState('');
  const [vehicleClass, setVehicleType] = useState('');
  const [runt, setRunt] = useState('');
  const [license, setLicense] = useState('');

  const createVehicle = async () => {
    await fetch(`${process.env.NEXT_PUBLIC_BACKEND_URL}/vehicle/new`, {
      method: 'POST',
      body: JSON.stringify({
        plate: plate,
        userEmail: session?.user?.email,
        vehicleClass: vehicleClass,
        serviceType: serviceType,
        licenseNumber: license,
        axiesAmount: parseInt(selectOption),
        runt: runt,
        category: selectCategory,
      }),
      headers: { 'Content-Type': 'application/json' },
    })
      .then((res) => {
        console.log(res);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    console.log('Select option is', selectOption);
    console.log('Select category is', selectCategory);
  }, [selectOption || selectCategory || onOpen]);

  const categories = [
    { id: 1, category: 'PESADO' },
    { id: 2, category: 'LIGERO' },
    { id: 3, category: 'MOTOCICLETA' },
  ];
  const options = [
    { id: 1, axies: '2' },
    { id: 2, axies: '4' },
    { id: 3, axies: '6' },
    { id: 4, axies: '8' },
    { id: 5, axies: '10' },
    { id: 6, axies: '12' },
  ];
  return (
    <>
      <Button onPress={onOpen} color="primary" type="submit">
        Registrar Carro
      </Button>
      <Modal isOpen={isOpen} onOpenChange={onOpenChange} placement="center">
        <ModalContent>
          {(onClose) => (
            <>
              <ModalHeader className="flex flex-col gap-1">
                Registrar nuevo vehículo
              </ModalHeader>
              <ModalBody>
                <div className="flex flex-col gap-4">
                  <div className="flex flex-row space-x-2">
                    <Input
                      autoFocus
                      label="Placa"
                      placeholder="Escribe la placa"
                      variant="bordered"
                      className="w-4/5"
                      value={plate}
                      onChange={({ target }) => setPlate(target.value)}
                    />
                    <Input
                      label="Tipo de servicio"
                      placeholder="Escribe el tipo de servicio"
                      variant="bordered"
                      value={serviceType}
                      onChange={({ target }) => setServiceType(target.value)}
                    />
                  </div>
                  <div className="flex flex-row space-x-2">
                    <Input
                      autoFocus
                      label="Clase de vehiculo"
                      placeholder="Escribe la clase de vehículo"
                      variant="bordered"
                      value={vehicleClass}
                      onChange={({ target }) => setVehicleType(target.value)}
                    />
                    <Select
                      items={options}
                      label="Cantidad de Ejes"
                      placeholder="Ejes"
                      className="max-w-xs "
                      value={selectOption}
                    >
                      {(option) => (
                        <SelectItem
                          key={option.id}
                          value={option.id}
                          onClick={() => setSelectOption(option?.axies)}
                        >
                          {option.axies}
                        </SelectItem>
                      )}
                    </Select>
                  </div>
                  <Input
                    autoFocus
                    label="Número de licencia"
                    placeholder="Escribe el número de licencia"
                    variant="bordered"
                    value={license}
                    onChange={({ target }) => setLicense(target.value)}
                  />
                  <div className="flex flex-row justify-center space-x-2">
                    <Select
                      items={categories}
                      label="Categoría de vehículo"
                      placeholder="Categoría"
                      className="max-w-xs"
                      value={selectOption}
                    >
                      {(category) => (
                        <SelectItem
                          key={category.id}
                          value={category.id}
                          onClick={() => setSelectCategory(category?.category)}
                        >
                          {category?.category}
                        </SelectItem>
                      )}
                    </Select>
                    <Input
                      autoFocus
                      label="RUNT"
                      placeholder="Escribe el RUNT"
                      variant="bordered"
                      value={runt}
                      onChange={({ target }) => setRunt(target.value)}
                    />
                  </div>
                </div>
              </ModalBody>
              <ModalFooter>
                <Button color="danger" variant="flat" onPress={onClose}>
                  Cerrar
                </Button>
                <Button
                  color="primary"
                  onPress={onClose}
                  onClick={() => createVehicle()}
                >
                  Registrar
                </Button>
              </ModalFooter>
            </>
          )}
        </ModalContent>
      </Modal>
    </>
  );
};

export default CreateVehicle;
