import { 
  createBrowserRouter, 
  createRoutesFromElements, 
  Route 
} from "react-router-dom";

import PageLayout from "./components/PageLayout";

import Home from "./pages/Home"
import LoginPage from "./pages/LoginPage";
import ErrorPage from "./pages/ErrorPage";

const router = createBrowserRouter(
  createRoutesFromElements([
    // root pages:
    <Route path="/" element={<PageLayout />}>
      <Route index element={<Home />} />

      <Route path="/login" element={<LoginPage />} />,
      
      {/* error: */}
      <Route path="*" element={<ErrorPage />} />
    </Route>,

    // full pages:
  ])
);

export default router;