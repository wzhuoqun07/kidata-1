import { 
  createBrowserRouter, 
  createRoutesFromElements, 
  Route 
} from "react-router-dom";

import PageLayout from "./components/PageLayout";

import Home from "./pages/Home"
import About from "./pages/About";
import Error from "./pages/Error";

import Lessons from "./pages/Lessons";
import LessonPage from "./pages/LessonPage"

const router = createBrowserRouter(
  createRoutesFromElements([
    // root pages:
    <Route path="/" element={<PageLayout />}>
      <Route index element={<Home />} />
      
      <Route path="/about" element={<About />} />
      <Route path="/lessons" element={<Lessons />} />
      {/* individual lessons: */}
      <Route path="/lessons/:id" element={<LessonPage />} />
      {/* /lessons/ */}
      {/* error page: */}
      <Route path="*" element={<Error />} />
    </Route>,

    // full pages:
  ])
);

export default router;