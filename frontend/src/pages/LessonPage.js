import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";

function LessonPage(props) {
  const { id } = useParams();

  const [ content, setContent ] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/pull/slides/" + id)
      .then(response => {
        console.log(response.json());
      })
      .catch(ctx => console.error(ctx));
  })

  return (
    <></>
  )
}

export default LessonPage;