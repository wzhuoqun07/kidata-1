import PageLayout from "./components/PageLayout"
import {BrowserRouter, Routes, Route} from 'react-router-dom';

import "./sass/main.scss"
import Home from "./pages/Home";
import Game from "./pages/Game";
import Lesson from "./pages/Lesson";
import Contact from "./pages/Contact";
import Login from "./pages/Login";
import BasicGraph from "./pages/BasicGraph";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path={"/"} element={<PageLayout />}>
              <Route index element={<Home />}/>
              <Route path={"/game"} element={<Game />}/>
              <Route path={"/lesson"} element={<Lesson />}/>
              <Route path={"/ContactUs"} element={<Contact />}/>
              <Route path={"/Login"} element={<Login />}/>
              <Route path={"/Lesson/BasicGraph"} element={<BasicGraph />}/>
          </Route>
        </Routes>
      </BrowserRouter>

  );
}

export default App;
