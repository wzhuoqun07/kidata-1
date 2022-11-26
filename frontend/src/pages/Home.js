import { Link } from "react-router-dom";
import Markdown from "markdown-to-jsx";

function HeroLink(props) {
  return (
    <Link to={props.to}>
      <li>
        <h3>{props.text}</h3>
      </li>
    </Link>
  )
}

function Home() {
  return (
    <div className="home">
      <div className="split-container hero">
        <div className="image-container">
          <img src="logo.png" />
        </div>
        <div className="quickstart">
          <h1 className="title">
            Data has never been more fun!
          </h1>
          <h3>Jump right in:</h3>

          <ul className="hero-nav">
            <HeroLink to="/lessons" text="Lessons" />
            <HeroLink to="/games" text="Games" />
          </ul>
        </div>
      </div>
      
      <div className="split-container welcome">
        <div>
          <h1 className="title">Welcome!</h1>
          <p>
            KIDATA is a learning platform designed to teach kids about data 
            science in a way that appeals to them.  
          </p>
        </div>
        <div>

        </div>
      </div>

      {/* temporary: */}
      <span style={{"padding-bottom": "400px"}} />
    </div>
  )
}

export default Home;