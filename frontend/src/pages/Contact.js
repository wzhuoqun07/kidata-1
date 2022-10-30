function Contact() {
    return (
        <div className="Contact">
            <div className="page-card">
                <p>
                    <h1>Contact Us</h1>
                    <p>Thank you for Taking time to contact us, Place provide the following information</p>
                    <br></br>
                    <br></br>
                </p>
                <form action='' method='Post'>
                    <section id='info'>
                        <label for='name'>Name</label>
                        <br></br>
                        <input type='text' name='name' id='name' ></input>
                        <br></br>
                        <label for='email'>Email</label>
                        <br></br>
                        <input type='text' id='email' name='email' ></input>
                        <br></br>
                        <label for='questiontype'>Question Type</label>
                        <br></br>
                        <select id='questiontype' name='questiontype'>
                            <option value='content'>Content</option>
                            <option value='advise'>Advice</option>
                            <option value='bugreport'>Bug</option>
                        </select>
                        <br></br>
                        <br></br>

                        <label for='question'>Question</label>
                        <br></br>
                        <textarea id='question' name='question' rows='5' cols='30'>
                            question is:
                        </textarea>
                    
                        <br></br>
                        <input type='submit' value='submittion'></input>


                    </section>
                </form>
            </div>
        </div>

    );
}

export default Contact;