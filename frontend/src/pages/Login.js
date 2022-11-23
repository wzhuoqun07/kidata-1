/* eslint-disable react/jsx-no-comment-textnodes */
function Login() {
    return (
        <div className="Login">
            <div className="page-card">
                <form action='' method='Post'>
                    <section class='login'>
                        <label for='username'>Username</label>
                        <br></br>
                        <input type='text' id='username' name ='username'></input>
                        <br></br>
                        <label for='password'>Password</label>
                        <br></br>
                        <input type='password' id='password' name ='password'></input>
                    </section>
                    <section class='submission'>
                        <input type='submit' value='Submit'></input>
                    </section>
                </form>
            </div>
        </div>
    );
}

export default Login;