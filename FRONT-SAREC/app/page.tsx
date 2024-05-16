'use client';

import React from 'react';
import { title, subtitle } from '@/components/primitives';
import { useRouter } from 'next/navigation';

export default function Home() {
  const router = useRouter();
  return (
    <div className="backgroundHomepage flex items-center justify-center h-screen">
      <div className="bg-white bg-opacity-80 p-32 rounded-lg grid justify-items-center dark:bg-black dark:opacity-90">
        <h1 className={title()}>Bienvenidos al Sistema&nbsp;</h1>
        <h1 className={title({ color: 'yellow' })}>SAREC&nbsp;</h1>
        <h2 className={subtitle({ class: 'mt-2' })}>
          La nueva forma de viajar por Colombia
        </h2>
        <div className="w-full mt-8 gap-4 flex flex-col justify-center">
          <button
            className="bg-blue-500 text-white px-4 py-2 rounded"
            onClick={() => {
              router.push('/login');
            }}
          >
            Ingresar
          </button>
        </div>
      </div>
    </div>
  );
}
