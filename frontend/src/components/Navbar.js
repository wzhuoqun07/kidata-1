import { Link } from "react-router-dom";

function NavbarLink(props) {
  return (
    <Link to={props.to}>
      <li>
        {/* add icon? */}
        <h3>{props.text}</h3>
      </li>
    </Link>
  );
}

function Navbar() {
  return (
    <div className="navbar">
      <ul className="links">
        {/* this needs a component: */}
        <NavbarLink to="/" text="Home" />
        <NavbarLink to="/lessons" text="Lessons" />
        <NavbarLink to="/contact" text="Contact Us" />
        <NavbarLink to="/about" text="About" />
        <NavbarLink to="/login" text="Login (temporary)" />
      </ul>
      <div className="current-user">

      </div>
    </div>
  );
}

export default Navbar;