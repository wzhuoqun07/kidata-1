import Navbar from "./Navbar";

function Header() {
  return (
    <div id="header">
      <div className="header-card">
        <div className="header-content">
          <img 
            src="/"
            className="logo"
          />
          <h1>KIDATA (temporary title)</h1>
        </div>
        <Navbar />
      </div>
    </div>
  );
}

export default Header;