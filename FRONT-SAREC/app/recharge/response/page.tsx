'use client';

import { title } from '@/components/primitives';
import { useSearchParams } from 'next/navigation';

export default function RechargeResponsePage() {
  const searchParams = useSearchParams();
  const transactionState = searchParams.get('transactionState');

  return (
    <div>
      <h1 className={title()}>Confirmation</h1>
      <p>{transactionState}</p>
    </div>
  );
}
