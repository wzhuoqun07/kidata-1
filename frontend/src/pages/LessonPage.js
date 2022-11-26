import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";

import Markdown from "markdown-to-jsx";

function QuizChoice(props) {
  return (
    <li>
      <button
        // this needs some revision; may want to elevate this to be at the same
        // level as the component  
        onClick={event => props.onClick(event)}
      >
        { props.text }
      </button>
    </li>
  )
}

function QuizQuestion(props) {
  const { question, choices, answer } = props.content;
  
  return (
    <div>
      <h1>{ question }</h1>
      {
        // questions/choices should be returned as an array when stringify-ed,
        // so use map:
        choices.map((choice, i) => (
          // ...and return a div for each array entry:
          <QuizChoice 
            text={ `${String.fromCharCode(parseInt('A') + i)}. ${choice}` }
          />
        ))
      }
    </div>
  )
}

function LessonContent(props) {
  const { quiz } = props;

  let choices;
  if (quiz) {
    choices = quiz.map(content => (
      <QuizQuestion content={content} />
    ));
  }

  return (
    <>
      <Markdown className="markdown" children={ props.markdown } />
      {/* if we don't have a quiz, just don't render anything here: */}
      { choices }
    </>
  )
}

// status screens:
function FetchLoading() {
  return (
    <div className="lesson">

    </div>
  )
}

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
  const [ quiz, setQuiz ] = useState(null);

  const [ failure, setFailure ] = useState(false);
  
  useEffect(() => {
    fetch("http://localhost:8080/pull/slides/" + id)
      .then(response => response.json())
      // apply lesson content:
      .then(body => {
        // if we have no markdown, need to invoke an error:
        const markdown = body.markdown;
        if (!markdown)
          // invoke the .catch:
          throw new Error("Did not receieve markdown body from server.");
        
        body.quiz && setQuiz(JSON.parse(body.quiz));

        setContent(markdown);
      })
      .catch(reason => {
        setFailure(true);
        console.log(reason);
      });
  }, []);

  let renderElement = <FetchLoading />
  
  // is there a better way to do this?:
  if (failure) {
    renderElement = <FetchError />
  } else if (content) {
    renderElement = <LessonContent
      markdown={ content }
      // rely on quiz being falsy here:
      quiz={ quiz }
    />
  }
  
  return (
    <div className="lesson-page">
      { renderElement }
    </div>
  )
}

export default LessonPage;