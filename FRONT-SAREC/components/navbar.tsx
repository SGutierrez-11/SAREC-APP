import {
  Navbar as NextUINavbar,
  NavbarContent,
  NavbarMenu,
  NavbarBrand,
  NavbarItem,
  NavbarMenuItem,
} from '@nextui-org/navbar';
import { Kbd } from '@nextui-org/kbd';
import { Link } from '@nextui-org/link';
import { Input } from '@nextui-org/input';
import { siteConfig } from '@/config/site';
import NextLink from 'next/link';
import { ThemeSwitch } from '@/components/theme-switch';
import { SearchIcon } from '@/components/icons';
import { Logo } from '@/components/icons';
import ButtonSignOut from './signout/buttonSignOut';
import { usePathname } from 'next/navigation';
import { useSession } from 'next-auth/react';

export default function Navbar() {
  const pathname = usePathname();
  const { data: session, status } = useSession();

  const searchInput = (
    <Input
      aria-label="Search"
      classNames={{
        inputWrapper: 'bg-default-100',
        input: 'text-sm',
      }}
      endContent={
        <Kbd className="hidden lg:inline-block" keys={['command']}>
          K
        </Kbd>
      }
      labelPlacement="outside"
      placeholder="Search..."
      startContent={
        <SearchIcon className="text-base text-default-400 pointer-events-none flex-shrink-0" />
      }
      type="search"
    />
  );

  return (
    <NextUINavbar maxWidth="xl" position="sticky">
      <NavbarContent className="basis-1/5 sm:basis-full" justify="start">
        <NavbarBrand as="li" className="gap-3 max-w-fit">
          <NextLink className="flex justify-start items-center gap-1" href="/">
            <Logo />
            <p className="font-bold text-inherit">SAREC</p>
          </NextLink>
        </NavbarBrand>
        <ul className="hidden lg:flex gap-4 justify-start ml-2">
          {siteConfig.navItems.map((item) => (
            <NavbarItem key={item.href}></NavbarItem>
          ))}
        </ul>
      </NavbarContent>

      <NavbarContent className="sm:flex basis-1/5 sm:basis-full" justify="end">
        <NavbarItem className="sm:flex gap-2">
          <ThemeSwitch />
        </NavbarItem>
        <NavbarItem className="lg:flex">
          {pathname === '/' ||
          pathname === '/login' ||
          pathname === '/register' ? (
            <></>
          ) : (
            <ButtonSignOut />
          )}
        </NavbarItem>
      </NavbarContent>
      <NavbarMenu>
        {searchInput}
        <div className="mx-4 mt-2 flex flex-col gap-4">
          {siteConfig.navMenuItems.map((item, index) => (
            <NavbarMenuItem key={`${item}-${index}`}>
              <Link
                color={
                  index === siteConfig.navMenuItems.length - 2
                    ? 'primary'
                    : index === siteConfig.navMenuItems.length - 1
                    ? 'danger'
                    : 'foreground'
                }
                href={item.href}
                size="lg"
              >
                {item.label}
              </Link>
            </NavbarMenuItem>
          ))}
        </div>
      </NavbarMenu>
    </NextUINavbar>
  );
}
