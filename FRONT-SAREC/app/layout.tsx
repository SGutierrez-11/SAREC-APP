'use client';

import '@/styles/globals.css';
import { Metadata } from 'next';
import { siteConfig } from '@/config/site';
import { fontSans } from '@/config/fonts';
import Navbar from '@/components/navbar';
import { Link } from '@nextui-org/link';
import clsx from 'clsx';
import Providers from '@/context/Providers';

export const metadata: Metadata = {
  title: {
    default: siteConfig.name,
    template: `%s - ${siteConfig.name}`,
  },
  description: siteConfig.description,
  themeColor: [
    { media: '(prefers-color-scheme: light)', color: 'white' },
    { media: '(prefers-color-scheme: dark)', color: 'black' },
  ],
  icons: {
    icon: '/favicon.ico',
    shortcut: '/favicon-16x16.png',
    apple: '/apple-touch-icon.png',
  },
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en" suppressHydrationWarning>
      <head />
      <body
        className={clsx(
          'min-h-screen bg-background font-sans antialiased',
          fontSans.variable,
        )}
      >
        <Providers themeProps={{ attribute: 'class', defaultTheme: 'dark' }}>
          <div className="relative flex flex-col h-full">
            <Navbar />
            <main className="h-full flex-grow">{children}</main>
            <footer className="w-full flex items-center justify-center py-3 pt-2">
              <Link
                isExternal
                className="flex items-center gap-1 text-current"
                title="nextui.org homepage"
              >
                <span className="text-default-600 text-xs">Powered by</span>
                <p className="text-primary text-xs">TecnoSoluciones</p>
              </Link>
            </footer>
          </div>
        </Providers>
      </body>
    </html>
  );
}
