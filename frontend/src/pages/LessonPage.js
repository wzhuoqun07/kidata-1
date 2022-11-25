import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";

import Markdown from "markdown-to-jsx";

function LessonPage() {
  const { id } = useParams();
  
  const [ content, setContent ] = useState(null);
  // const [ didFail, setFailure ] = useState(false);

  useEffect(() => {
    fetch("http://localhost:8080/pull/slides/" + id)
      .then(response => response.json())
      // apply lesson content:
      .then(body => {
        if (!body.markdown)
          console.log("Uh oh.");

        setContent(body.markdown);
      })
      .catch(reason => console.log(reason));
  });

  return (
    <div>
      { content ? <Markdown children={ content } /> : <h2>Loading...</h2> }
    </div>
  )
}

export default LessonPage;