import {NavLink} from "react-router-dom";

function Lesson() {
    return (
        <div className="Lesson">
            <div className="page-card">
                <div className="content">
                    <h1>
                        Welcome to KIDATA's lessons
                    </h1>
                    <br/><br/><br/>
                    <p>
                        Based on this content, you can learn more interesting skills.</p>
                    <br/>
                </div>
                <div className="lesson-menu">
                    <h1>Menu</h1>
                    <br/>
                    <ul style={{listStyleType: "none"}}>
                        <li>
                            <NavLink to={"/Lesson/Grade1"} style={{textDecoration: "none", color: "black"}}>
                                <strong>Grade1</strong>
                            </NavLink>
                        </li>
                        <br/><br/><br/>
                        <li>
                            <NavLink to={"/Lesson/Grade2"} style={{textDecoration: "none", color: "black"}}>
                                <strong>Grade2</strong>
                            </NavLink>
                        </li>
                        <br/><br/><br/>
                        <li>
                            <NavLink to={"/Lesson/Grade3"} style={{textDecoration: "none", color: "black"}}>
                                <strong>Grade3</strong>
                            </NavLink>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    );
}

export default Lesson;
