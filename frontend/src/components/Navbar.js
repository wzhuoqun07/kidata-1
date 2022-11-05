import { Link } from "react-router-dom";

function NavbarLink(props) {
  return (
    <Link to={props.to}>
      <li>
        <h4>{props.text}</h4>
      </li>
    </Link>
  )
}

function Navbar() {
  return (
    // div, just so we have some sort of container and not a raw ul:
    <div className="navbar">
      <ul>
        <NavbarLink to="/" text="Home" />
        <NavbarLink to="/lessons" text="Lessons" />
        <NavbarLink to="/games" text="Games" />
        <NavbarLink to="/about" text="About" />
        <NavbarLink to="/contact" text="Contact" />
      </ul>
    </div>
  )
}

export default Navbar;