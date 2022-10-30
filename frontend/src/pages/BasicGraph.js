import {NavLink} from "react-router-dom";

function BasicGraph() {
    return (
        <div className="basic-graph">
            <div className="page-card">
                <div className="content">
                    <h1>
                        Basic Graphs
                    </h1>
                    <p>

                    </p>
                </div>
                <div className="lesson-menu">
                    <NavLink to={"/BasicGraph"}>Basic Graph</NavLink>
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                    <li><a href="#"><strong>???</strong></a></li>
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                    <li><a href="#"><strong>???</strong></a></li>
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                    <li><a href="#"><strong>???</strong></a></li>
                </div>
            </div>

        </div>
    );
}

export default BasicGraph;