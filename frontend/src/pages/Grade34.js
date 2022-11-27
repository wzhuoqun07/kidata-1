import {NavLink} from "react-router-dom";

function Grade34() {
    return (
        <div className="basic-graph">
            <div className="page-card">
                <div className="content">
                    <h1 className="title">
                        Grade 3 - 4
                    </h1>

                    <div className="lesson-title1">
                        <br></br>
                        <br></br>
                        
                    </div>
                    <div className="lesson-title2">
                        
                    </div>
                </div>
                
                <div className="lesson-menu">
                    <h1>Menu</h1>
                    <br></br>
                    <br></br>
                    <NavLink to={"/Lesson/Grade1_2"} style={{textDecoration: "none"}}>Grade 1-2</NavLink>
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                    <NavLink to={"/Lesson/Grade3_4"} style={{textDecoration: "none"}}>Grade 3-4</NavLink>
                    <br></br>
                    <br></br>
                    <br></br>
                    <br></br>
                    <NavLink to={"/Lesson/Grade5_6"} style={{textDecoration: "none"}}>Grade 5-6</NavLink>
                </div>
            </div>

        </div>
    );
}
export default Grade34;