import PageLayout from "./components/PageLayout"
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import "./sass/main.scss"
import Home from "./pages/Home";
import Lesson from "./pages/Lesson";
import Contact from "./pages/Contact";
import Login from "./pages/Login";
import Grade1 from "./pages/grades/Grade1";
import Grade2 from "./pages/grades/Grade2";
import Grade3 from "./pages/grades/Grade3";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path={"/"} element={<PageLayout />}>
              <Route index element={<Home />}/>
              <Route path={"/Lesson"} element={<Lesson />}/>
              <Route path={"/ContactUs"} element={<Contact />}/>
              <Route path={"/Login"} element={<Login />}/>
              <Route path={"/Lesson/Grade1"} element={<Grade1 />}/>
              <Route path={"/Lesson/Grade2"} element={<Grade2 />}/>
              <Route path={"/Lesson/Grade3"} element={<Grade3 />}/>
          </Route>
        </Routes>
      </BrowserRouter>
  );
}

export default App;
