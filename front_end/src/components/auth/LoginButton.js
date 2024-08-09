import './Auth.css';
import '../../index.css';
import React, { useState } from 'react';

const LoginButton = () => {
    const [toggle, setToggle] = useState(true);
    const [email, setEmail] = useState("");
    const [password, setPassword ] = useState("");
    const [status, setStatus] = useState(false);
    


    // *** PUT REQUEST FOR Log in FORM *** //
//   function logIn() {

    //TODO make form
    //TODO set email hook, set password
    //TODO PUT method change status in DB
    //TODO GET method id and status 
    //TODO set id global variable for trip and profile GET methods
    const urlSelection = "http://localhost:8080/login/" + email;
    const updatedData = {
      email: email,
      password: password,
      status: status,
    };

    fetch(urlSelection, {
      method: "PUT",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(updatedData),
    })
      .then((response) => {
        return response.json();
      })
    
    const handleClick = () => {
        setToggle(!toggle);
    }

    const selectionMade = (event) => {
        setPassword("friend");
        setStatus(true);
        setEmail(event.target.value)
    }
    
      return (
        <div className='page-container flex-login'>
            <div className='left-sidebar'>DEMO ONLY</div>
            <div className='signup-login-container '>
                <h2>Log In</h2>
                <div>This site is for demo purposes only. Please select a pre-existing user or create your own. </div>
                <div>** All created data will be deleted at midnight **</div>
                

                {toggle ? 
                    <form onSubmit={selectionMade} method="PUT" action={urlSelection}>
                        <select value={email} name='email' id='email'>
                            <option value=''>Select a email</option>
                            <option value='ed@the90s.com'>Ed@the90s.com</option>
                            <option value='edd@the90s.com'>Edd@the90s.com</option>
                            <option value='eddy@the90s.com'>Eddy@the90s.com</option>
                        </select>
                        {/* //TODO have password populate once a user is selected. */}
                        <button type="submit" onClick={selectionMade}>Log in</button>
                    </form>
                    :
                    <form>
                        <label>Please use a fake email</label>
                        <input type="email" id="email" name="email" placeholder="Email" />
                        <label>Password must be three characters. Because who wants to spend time on a password that is only going to be deleted?</label>
                        <input type="password" id="pwd" name="pwd" placeholder='Password'/>
                        <button type='submit'>Log In</button>
                    </form>
                }
                
                <button type='button' onClick={handleClick}>Create Your Own User</button>

               
            </div>
            <div className='right-sidebar'>
                    <div className='instructions'>
                        <label>
                        Password must be three characters. Because who wants to spend time on a password that is only going to be deleted?
                        </label>
                    </div>
                </div>
        </div>
        )
    }
// }

export default LoginButton