import {NavLink} from "react-router-dom";

function Lesson() {
    return (
        <div className="Lesson">
            <div className="page-card">
                <div className="content">
                    <h1>
                        Welcome to KIDATA's lessons
                    </h1>
                    <br/>
                    <br/>
                    <br/>
                    <p>
                        Based on this content, you can learn more interesting skills.</p>
                    <br/>
                    <p>
                        If you are tired of playing games, it will be a good choice to read them.
                    </p>
                </div>
                <div className="lesson-menu">
                    <NavLink to={"/Lesson/BasicGraph"}>Basic Graph</NavLink>
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                    <li><a href={undefined}><strong>???</strong></a></li>
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                    <li><a href={undefined}><strong>???</strong></a></li>
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                    <li><a href={undefined}><strong>???</strong></a></li>
                </div>
            </div>

        </div>
    );
}

export default Lesson;
