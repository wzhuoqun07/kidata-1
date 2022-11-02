import {NavLink} from "react-router-dom";

function Navbar() {
  return (
    <div id="navbar-container">
      <div className="navbar" >
          <nav>
              <NavLink to={"/"}>Home</NavLink> {"| "}
              <NavLink to={"/Lesson"}>Lesson</NavLink> {"| "}
              <NavLink to={"/ContactUs"}>Contact Us</NavLink> {"| "}
              <NavLink to={"/Login"}>Log in</NavLink>
          </nav>
      </div>
    </div>
  );
}

export default Navbar;