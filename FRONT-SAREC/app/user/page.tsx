'use client';

import React from 'react';
import Recharge from '@/components/recharge/recharge';
import TransactionInformation from '@/components/transaction/transactionInformation';
import Vehicles from '@/components/vehicle/vehiclesInformation';
import RecordsInformation from '@/components/record/recordsInformation';

export default function UserPage() {
  const [selected, setSelected] = React.useState(
    '/components/payu-prepayment.tsx',
  );

  const handleSidebarSelection = (option: string) => {
    // Handle the selected option here
    // {selected === 'payments' && <UserPayments/>}
    console.log('Selected option from sidebar:', option);
    setSelected(option);
  };
  return (
    <div className="w-full flex flex-col justify-center items-center gap-4">
      <Recharge />
      <RecordsInformation />
      <TransactionInformation />
      <Vehicles />
    </div>
  );
}
