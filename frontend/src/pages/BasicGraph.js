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
    const [uid, setUid] = React.useState('');
    const [age, setAge] = React.useState('');
    const [password, setPassword] = React.useState('');
    const [first_name, setFirst] = React.useState('');
    const [last_name, setLast] = React.useState('');
    const [email, setEmail] = React.useState('');
    const [type, setType] = React.useState('');
    const [points, setPoints] = React.useState('');
    const updateState = (name, age) => {
        setUid(uid);
        setAge(age);
        setPassword(password);
        setFirst(first_name);
        setLast(last_name)
        setEmail(email)
        setType(type)
        setPoints(points)
    }

    const getInfo = () => {
        const url = `http://localhost:8080/test1`;

        fetch(url)
        .then(response => response.json())
            .then((({uid: uid, age: age}) => updateState(uid, age)))
    }

    return (
        <div style={{textAlign: "center", fontFamily: "Times New Roman, Times, serif"}}>
            <button style={{fontSize: "1vw"}} onClick={getInfo}>Get Image</button>
            <br/>
            <h2>Uid: {uid}</h2>
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