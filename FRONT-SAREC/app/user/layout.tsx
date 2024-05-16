export default function UserLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <section className="flex flex-col p-5 w-full">
      <div className="">{children}</div>
    </section>
  );
}
