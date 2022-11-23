function GeneralInfo() {
    return (
        <div className="GeneralInfo">
            <label htmlFor='name'>Name</label>
            <br></br>
            <input type='text' name='name' id='name'></input>
            <br></br>
            <br></br>
            <label htmlFor='email'>Email</label>
            <br></br>
            <input type='text' id='email' name='email'></input>
            <br></br>
            <br></br>
        </div>
    )
}

function QuestionInfo() {
    return (
        <div className="QuestionInfo">
            <label htmlFor='type'>Question Type</label>
            <br></br>
            <select id='type' name='type'>
                <option value='content'>Content</option>
                <option value='advise'>Advice</option>
                <option value='bugreport'>Bug</option>
            </select>
            <br></br>
            <br></br>
            <label htmlFor='question'>Question</label>
            <br></br>
            <textarea id='question' name='question' rows='7'
                      cols='50' style={{resize: "none"}}/>
            <br></br>
            <input type='submit' value='submission'></input>
        </div>
    )
}

function Contact() {
    return (
        <div className="Contact">
            <div className="page-card">
                    <h1>Contact Us</h1>
                    <br></br>
                    <br></br>
                <form action='' method='Post'>
                    <section id='info'>
                        <GeneralInfo/>
                        <QuestionInfo/>
                    </section>
                </form>
            </div>
        </div>
    );
}

export default Contact;