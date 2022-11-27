import { Link } from "react-router-dom";
import {NavLink} from "react-router-dom";

function LessonCard(props) {
  const subject = props.subject;
  
  return (
    <Link to={props.to}>
      <div className="lesson-card">
        <img id="logo" />
        
        <h3>{props.lessonName}</h3>
        <h5>{props.subject}</h5>
      </div>
    </Link>
  )
}

function Lessons() {
  return (
    <div className="lessons">
      <h1 className="title">Lessons</h1>
        <div className="lesson-menu">
        <h1>Menu</h1>
          <br/><br/>
          <NavLink to={"/Lesson/Grade1_2"} style={{textDecoration: "none"}}>Grade 1-2</NavLink>
          <br/><br/><br/><br/>
          <NavLink to={"/Lesson/Grade3_4"} style={{textDecoration: "none"}}>Grade 3-4</NavLink>
          <br/><br/><br/><br/>
          <NavLink to={"/Lesson/Grade5_6"} style={{textDecoration: "none"}}>Grade 5-6</NavLink>
          <br/>          
        </div>

      
    </div>
  )
}

export default Lessons;