import {NavLink, Outlet} from "react-router-dom";

function LessonLayout() {
    return (
        <>
            <div className="Lesson">
                <div className="page-card">
                    <div className="content">

                    </div>
                    <div className="lesson-menu">
                        <h1>Menu</h1>
                        <br></br>
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
            <Outlet />
        </>
    );
}

export default LessonLayout;