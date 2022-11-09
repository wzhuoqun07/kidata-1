import { 
  createBrowserRouter, 
  createRoutesFromElements, 
  Route 
} from "react-router-dom";

import PageLayout from "./components/PageLayout";

import Home from "./pages/Home"
import Error from "./pages/Error";

const router = createBrowserRouter(
  createRoutesFromElements([
    // root pages:
    <Route path="/" element={<PageLayout />}>
      <Route index element={<Home />} />

      {/* error page: */}
      <Route path="*" element={<Error />} />
    </Route>,

    // full pages:
  ])
);

export default router;