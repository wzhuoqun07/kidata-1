import { Link } from "react-router-dom";

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

      {/* TODO: add links for each individual lesson */}
    </div>
  )
}

export default Lessons;