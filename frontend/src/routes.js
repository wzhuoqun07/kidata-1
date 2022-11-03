import { 
  createBrowserRouter, 
  createRoutesFromElements, 
  Route 
} from "react-router-dom";

import Home from "./pages/Home"
import LoginPage from "./pages/LoginPage";
import ErrorPage from "./pages/ErrorPage";

const router = createBrowserRouter(
  createRoutesFromElements([
    // root pages:
    <Route index element={<Home />} />,

    // full pages:
    <Route path="/login" element={<LoginPage />} />,

    // error:
    <Route path="*" element={<ErrorPage />} />
  ])
);

export default router;