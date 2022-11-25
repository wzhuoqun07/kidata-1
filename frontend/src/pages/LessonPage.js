import { useParams } from "react-router-dom";

function LessonPage(props) {
  const { id } = useParams();

  console.log(id);
  
  return (
    <></>
  )
}

export default LessonPage;