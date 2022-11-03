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
              <NavLink style={({isActive}) => isActive ? activeStyle : inactive}
                       to={"/"} end>Home</NavLink> {"| "}
              <NavLink style={({isActive}) => isActive ? activeStyle : inactive}
                       to={"/Lesson"}>Lesson</NavLink> {"| "}
              <NavLink style={({isActive}) => isActive ? activeStyle : inactive}
                       to={"/ContactUs"}>Contact Us</NavLink> {"| "}
              <NavLink style={({isActive}) => isActive ? activeStyle : inactive}
                       to={"/Login"}>Log in</NavLink>
          </nav>
      </div>
    </div>
  );
}

export default Navbar;