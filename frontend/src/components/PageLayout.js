import { Outlet } from "react-router-dom";

import Header from "./Header";
import Footer from "./Footer";

export default function createPageBase(content) {
  return (
    <>
      <Header />
      <Outlet />
      
      <div id="content">
        {content}
      </div>
      
      <Footer />
    </>
  );
}