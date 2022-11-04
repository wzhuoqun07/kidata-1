/* eslint-disable react/jsx-no-comment-textnodes */
function Login() {
    return (
        <div className="Login">
            <div className="page-card">
                <form action='' method='Post'>
                    <section>
                        <label>Username</label>
                        <br></br>
                        <input type='text' id='username' name ='username'></input>
                        <br></br>
                        <label>Password</label>
                        <br></br>
                        <input type='password' id='password' name ='password'></input>
                    </section>
                    <section>
                        <input type='submit' value='Submit'></input>
                    </section>
                </form>
            </div>
        </div>
    );
}

export default Login;