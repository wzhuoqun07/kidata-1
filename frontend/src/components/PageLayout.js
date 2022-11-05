import Navbar from "./Navbar";
import Footer from "./Footer";
import {Outlet} from "react-router-dom";

function PageLayout() {
  return (
    <>
        <Navbar />
        <Outlet />
        <Footer />
    </>
  );
}

export default PageLayout;