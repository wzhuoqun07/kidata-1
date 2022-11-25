import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";

function LessonPage(props) {
  const { id } = useParams();

  const [ content, setContent ] = useState("");

  useEffect(() => {
    async function getContent() {
      const response = await fetch("http://localhost:8080/pull/slides/" + id);
      const content = await response.json();

      console.log("Got content:", content);
  
      setContent(content);
    }

    getContent()
      .catch(reason => console.log(reason));
  });

  return (
    <></>
  )
}

export default LessonPage;