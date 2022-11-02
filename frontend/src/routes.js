import { 
  createBrowserRouter, 
  createRoutesFromElements, 
  Route 
} from "react-router-dom";

import Home from "./pages/Home"

const router = createBrowserRouter(
  createRoutesFromElements([
    // root pages:
    <Route index element={<Home />} />,

    // full pages:
    <Route path="/login" element={<div>hello!</div>} />
  ])
);

export default router;