import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";

import Markdown from "markdown-to-jsx";

function FetchError() {
  return (
    <div>
      A not-so-pretty error screen. Something went wrong.
    </div>
  )
}

function LessonPage() {
  const { id } = useParams();

  const [ content, setContent ] = useState(null);
  const [ failure, setFailure ] = useState(false);

  useEffect(() => {
    fetch("http://localhost:8080/pull/slides/" + id)
      .then(response => response.json())
      // apply lesson content:
      .then(body => {
        if (!body.markdown)
          console.log("Uh oh.");

        setContent(body.markdown);
      })
      .catch(reason => {
        setFailure(true);
        console.log(reason);
      });
  });

  return (
    <div className="markdown-content">
      {content ? <Markdown children={content} /> : <FetchError/>}
    </div>
  )
}

export default LessonPage;