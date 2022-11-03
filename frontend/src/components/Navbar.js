import {NavLink} from "react-router-dom";

const activeStyle = {
    color: 'red',
    borderBottom: '1em, solid, black',
    textDecoration: 'none'
}

const inactive = {
    color: 'black',
    borderBottom: '1em, solid, black',
    textDecoration: 'none'
}

function Navbar() {
  return (
    <div id="navbar-container">
      <div className="navbar" >
          <nav>
<<<<<<< HEAD
              <NavLink style={({isActive}) => isActive ? activeStyle : inactive}
                       to={"/"} end>Home</NavLink> {"| "}
              <NavLink style={({isActive}) => isActive ? activeStyle : inactive}
                       to={"/Lesson"}>Lesson</NavLink> {"| "}
              <NavLink style={({isActive}) => isActive ? activeStyle : inactive}
                       to={"/ContactUs"}>Contact Us</NavLink> {"| "}
              <NavLink style={({isActive}) => isActive ? activeStyle : inactive}
                       to={"/Login"}>Log in</NavLink>
=======
              <NavLink to={"/"}>Home</NavLink> {"| "}
              <NavLink to={"/Lesson"}>Lesson</NavLink> {"| "}
              <NavLink to={"/ContactUs"}>Contact Us</NavLink> {"| "}
              <NavLink to={"/Login"}>Log in</NavLink>
>>>>>>> 3fa5c29d5ea1791afb8248ab27cde0d0bb2e3dca
          </nav>
      </div>
    </div>
  );
}

export default Navbar;