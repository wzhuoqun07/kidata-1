import {NavLink} from "react-router-dom";

function Content() {
    return (
        <div className="content">
            <h1>
                Basic Graphs
            </h1>
        </div>
    )
}

function Menu() {
    return (
        <div className="lesson-menu">
            <NavLink to={"/Lesson/BasicGraph"}>Basic Graph</NavLink>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <li><a href={null}><strong>???</strong></a></li>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <li><a href={null}><strong>???</strong></a></li>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <li><a href={null}><strong>???</strong></a></li>
        </div>
    )
}

function BasicGraph() {
    return (
        <div className="basic-graph">
            <div className="page-card">
                <Content/>
                <Menu/>
            </div>

        </div>
    );
}

export default BasicGraph;