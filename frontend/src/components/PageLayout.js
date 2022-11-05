import { Outlet } from "react-router-dom";

import Header from "./Header";
import Footer from "./Footer";

function PageLayout() {
  return (
    <>
      <Header />
      
      <div className="page-content">
        <Outlet />
      </div>
      
      <Footer />
    </>
  );
}

export default PageLayout;