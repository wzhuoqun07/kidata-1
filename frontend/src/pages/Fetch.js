import {NavLink} from "react-router-dom";
import React, {useEffect} from 'react';

function Content() {
    return (
        <div className="content" onLoad={FetchTest}>
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
            <NavLink to={"/Lesson/Fetch"}>Basic Graph</NavLink>
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

    useEffect(() => {
        const url = `http://localhost:8080/fetch`;
        fetch(url)
            .then(response => response.json())
            .then(({name: name, age: age}) => updateState(name, age))
    }, [])

    return (
        <div style={{textAlign: "center",
            fontFamily: "Times New Roman, Times, serif"}}>
            <br/>
            <h2>Name: {name}</h2>
            <h2>Age: {age}</h2>
        </div>
    )
}

function Fetch(){
    return (
        <div className="basic-graph">
            <div className="page-card">
                <Content/>
                <Menu/>
            </div>
        </div>
    );
}

export default Fetch;