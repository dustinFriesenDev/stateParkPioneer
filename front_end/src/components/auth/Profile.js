import './Auth.css';

const Profile = () => {
    
    return (
        
        //checking to see if the user is not authenticated before seeing the login button */
            <div className='page-container'>
            <p>Info will be shown here.</p>
            {/* <article className="profile">
                {user?.picture && <img src={user.picture} alt={user?.name} />}
                <h2>{user?.name}</h2>
                <ul>
                    {Object.keys(user).map((objKey, i) => 
                        <li key={i}>{objKey}: {user[objKey]}</li>
                    )}
                </ul>
            </article> */}
            </div>
        )
}

export default Profile