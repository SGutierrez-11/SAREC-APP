'use client';
import { Input } from '@nextui-org/react';
import { useState } from 'react';
import { Md5 } from 'ts-md5';
import { randomBytes, randomUUID } from 'crypto';

export function PayuPrepayment() {
  const [referenceId, setReferenceID] = useState(
    randomBytes(20).toString('hex'),
  );
  const [amount, setAmount] = useState(20000);
  const [signature, setSignature] = useState(
    Md5.hashStr(`4Vj8eK4rloUd272L48hsrarnUA~508029~${referenceId}~20000~COP`),
  );

  const handleAmountChange = (newAmount: number) => {
    setAmount(newAmount);
    const newSignature = `4Vj8eK4rloUd272L48hsrarnUA~508029~${referenceId}~${newAmount}~COP`;
    setSignature(Md5.hashStr(newSignature));
  };

  return (
    <form
      method="post"
      action="https://sandbox.checkout.payulatam.com/ppp-web-gateway-payu/"
      className="flex gap-2"
    >
      <input name="merchantId" type="hidden" value="508029" />
      <input name="accountId" type="hidden" value="512321" />
      <input
        name="description"
        type="hidden"
        value="Recarga pre-pago sistema de peajes SAREC"
      />
      <input name="referenceCode" type="hidden" value={referenceId} />
      <Input
        name="amount"
        type="number"
        value={String(amount)}
        onChange={(e) => handleAmountChange(e.target.valueAsNumber)}
        startContent={
          <div className="pointer-events-none flex items-center">
            <span className="text-default-400 text-small">$</span>
          </div>
        }
      />
      <input name="currency" type="hidden" value="COP" />
      <input name="signature" type="hidden" value={signature} />
      <input name="test" type="hidden" value="1" />
      <input
        name="responseUrl"
        type="hidden"
        value="http://test.com/recharge/response"
      />
      <input
        name="confirmationUrl"
        type="hidden"
        value="http://test.com/recharge/confirmation"
      />
      <Input name="Recargar" type="submit" value="Recargar" color="primary" />
    </form>
  );
}