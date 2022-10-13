import Navbar from "../components/Navbar";
import Footer from "../components/Footer";

import Home from "./Home";

function PageLayout() {
  return (
    <div className="page-container">
      <div id="header">
        <Navbar />
      </div>
      <div id="content">
        {/* placeholder; routes go here: */}
        <Home />
      </div>
      <div id="footer">
        <Footer />
      </div>
    </div>
  );
}

export default PageLayout;