import { 
  createBrowserRouter, 
  createRoutesFromElements, 
  Route 
} from "react-router-dom";

import PageLayout from "./components/PageLayout";

import Home from "./pages/Home"
import About from "./pages/About";
import Error from "./pages/Error";
import Contact from "./pages/Contact"
import Lessons from "./pages/Lessons";
import LessonPage from "./pages/LessonPage"

import Grade12 from "./pages/Grade12";
import Grade34 from "./pages/Grade34";
import Grade56 from "./pages/Grade56";


const router = createBrowserRouter(
  createRoutesFromElements([
    // root pages:
    <Route path="/" element={<PageLayout />}>
      <Route index element={<Home />} />
      <Route path="/contact" element={<Contact />} />
      <Route path="/about" element={<About />} />
      <Route path="/lessons" element={<Lessons />} />
      {/* individual lessons: */}
      <Route path="/lessons/:id" element={<LessonPage />} />
      {/* /lessons/ */}
      {/* error page: */}
      <Route path="*" element={<Error />} />

      <Route path={"/Lesson/Grade1_2"} element={<Grade12 />}/>
      <Route path={"/Lesson/Grade3_4"} element={<Grade34 />}/>
      <Route path={"/Lesson/Grade5_6"} element={<Grade56 />}/>      
    </Route>,

    // full pages:
  ])
);

export default router;