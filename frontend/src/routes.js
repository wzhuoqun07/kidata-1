import { 
  createBrowserRouter, 
  createRoutesFromElements, 
  Route 
} from "react-router-dom";

import PageLayout from "./components/PageLayout";

import Home from "./pages/Home"
import About from "./pages/About";
import Error from "./pages/Error";

const router = createBrowserRouter(
  createRoutesFromElements([
    // root pages:
    <Route path="/" element={<PageLayout />}>
      <Route index element={<Home />} />
      <Route path="/about" element={<About />} />

      {/* error page: */}
      <Route path="*" element={<Error />} />
    </Route>,

    // full pages:
  ])
);

export default router;