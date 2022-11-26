import Navbar from "./Navbar";

function Header() {
  return (
    <div className="header">
      <img
        id="logo"
        src="/logo.png"
      />
      <Navbar />
    </div>
  );
}

export default Header;