import { Link } from "react-router-dom";

function Error() {
  return (
    // this is a ridiculously lazy solution, want to replace with markdown:
    <div className="error-page">
      <h1 className="title">:(</h1>

      {/* should we leave this as a line break or properly format it?: */}
      <br/>

      <h2>Looks like you did something our app didn't like.</h2>
      <h3>Ready to go back?</h3>
      
      <br/>
      
      <Link to="/">
        <div className="to-home">
          <h3>Return to KIDATA</h3>
        </div>
      </Link>

      <h5>
        If you believe this is an error, please send us a bug report via the 
        contact section found at the bottom of the homepage!
      </h5>
    </div>
  )
}

export default Error;