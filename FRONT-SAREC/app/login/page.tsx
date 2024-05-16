'use client';

import React from 'react';
import { title, subtitle } from '@/components/primitives';
import { Divider, Input, Button } from '@nextui-org/react';
import { EyeFilledIcon, EyeSlashFilledIcon } from '@/components/icons';
import { signIn } from 'next-auth/react';
import { useRouter } from 'next/navigation';

export default function Login() {
  const [isVisible, setIsVisible] = React.useState(false);
  const [username, setUsername] = React.useState('');
  const [password, setPassword] = React.useState('');
  const [errors, setErrors] = React.useState<string[]>([]);
  const router = useRouter();
  const handleSubmit = async () => {
    const responseNextAuth = await signIn('credentials', {
      username: username,
      password: password,
      redirect: false,
    });

    if (responseNextAuth?.error) {
      setErrors(responseNextAuth.error.split(','));
      return;
    }

    router.push('/user');
  };

  const toggleVisibility = () => setIsVisible(!isVisible);
  return (
    <section className="flex flex-col items-center justify-center gap-4 py-8 md:py-10">
      <div className="inline-block max-w-lg text-center justify-center px-5">
        <h1 className={title()}>Sistema&nbsp;</h1>
        <h1 className={title({ color: 'yellow' })}>SAREC&nbsp;</h1>
        <br />
        <h1 className={title()}>La nueva forma de viajar por Colombia</h1>
        <h2 className={subtitle({ class: 'mt-4' })}>
          Sistema de recaudo electrónico de peajes.
        </h2>
      </div>
      <div className="mt-8"></div>
      <Divider className="my-4" />
      <Input
        type="id"
        label="Correo Electrónico"
        placeholder="Ingrese su correo electrónico"
        variant="bordered"
        className="max-w-xs"
        value={username}
        onChange={({ target }) => setUsername(target.value)}
      />
      <Input
        label="Contraseña"
        variant="bordered"
        placeholder="Ingrese su contraseña"
        value={password}
        onChange={({ target }) => setPassword(target.value)}
        endContent={
          <button
            className="focus:outline-none"
            type="button"
            onClick={toggleVisibility}
          >
            {isVisible ? (
              <EyeSlashFilledIcon className="text-2xl text-default-400 pointer-events-none" />
            ) : (
              <EyeFilledIcon className="text-2xl text-default-400 pointer-events-none" />
            )}
          </button>
        }
        type={isVisible ? 'text' : 'password'}
        className="max-w-xs"
      />
      <span className="text-primary text-sm cursor-pointer">
        ¿Olvidaste tu contraseña?
      </span>
      <span className=" text-sm cursor-pointer">
        ¿No tienes cuenta?
        <span className="text-primary text-sm cursor-pointer font-bold">
          {' '}
          Registrate
        </span>
      </span>
      <Button color="primary" onClick={handleSubmit}>
        Ingresar
      </Button>
      {errors.length > 0 && (
        <div className="alert alert-danger mt-2">
          <ul className="mb-0">
            {errors.map((error) => (
              <li key={error}>{error}</li>
            ))}
          </ul>
        </div>
      )}
    </section>
  );
}
