import {NavLink} from "react-router-dom";
import React from 'react';

function Content() {
    return (
        <div className="content">
            <h1>
                Basic Graphs
            </h1>
            <FetchTest/>
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

function FetchTest() {
    const [name, setName] = React.useState('');
    const [age, setAge] = React.useState('');
    const updateState = (name, age) => {
        setName(name);
        setAge(age);
    }

    const getInfo = () => {
        const url = `http://localhost:8080/fetch`;

        fetch(url)
        .then(response => response.json())
            .then((({name: name1, age: age1}) => updateState(name1, age1)))
    }

    return (
        <div style={{textAlign: "center", fontFamily: "Times New Roman, Times, serif"}}>
            <button style={{fontSize: "1vw"}} onClick={getInfo}>Get Image</button>
            <br/>
            <h2>Name: {name}</h2>
            <h2>Age: {age}</h2>

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