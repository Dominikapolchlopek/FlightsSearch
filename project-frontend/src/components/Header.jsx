import { Link } from 'react-router'
import './header.css'
import { useState } from 'react'
import axios from 'axios'

export function Header({ isLoginOpen, setIsLoginOpen, userId, setUserId }) {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSignUp = async () => {
        if (!email || !password) {
            alert("Proszę uzupełnić email i hasło!");
            return;
        }

        try {
            const response = await axios.post('http://localhost:8080/api/v1/auth/signup', {
                Email: email,          
                PasswordHash: password 
            });

            console.log("Rejestracja udana:", response.data);
            
            setUserId(response.data.Id);
            setIsLoginOpen(false);
            
            setEmail('');
            setPassword('');

        } catch (error) {
            console.error("Błąd podczas rejestracji:", error);
            alert("Nie udało się zarejestrować. Spróbuj ponownie.");
        }
    }
     const handleLogin = async () => {
        if (!email || !password) {
            alert("Proszę uzupełnić email i hasło!");
            return;
        }

        try {
            const response = await axios.post('http://localhost:8080/api/v1/auth/login', {
                Email: email,          
                PasswordHash: password 
            });

            
            if (response.data.status === 401){
                setUserId(null)
                alert("Nie udało się zalogować. Spróbuj ponownie.")
            }else{
                console.log("Logowanie udane:", response.data);
                setUserId(response.data.Id);
                setIsLoginOpen(false);
                setEmail('');
                setPassword('');
            }
            
            
            
            

        } catch (error) {
            console.error("Błąd podczas logowania:", error);
            alert("Nie udało się zalogować. Spróbuj ponownie.");
        }
    }
    return (
        <div className="header">
            <div className="left-section">
                <Link to="/" className="header-link">
                    <img className="logo"
                        src="images/logo-white.png" />
                    <img className="mobile-logo"
                        src="images/mobile-logo-white.png" />
                </Link>
            </div>

            <div className="middle-section">



            </div>

            <div className="right-section">
                <Link className="search-link header-link" to="/">
                    <span className="search-text">Search</span>
                </Link>
                <Link className="favorites-link header-link"
                    to="/favorites"
                    onClick={(e) => {
                        if (!userId) {
                            e.preventDefault();
                            setIsLoginOpen(true);
                        }
                    }}>

                    <span className="orders-text">Favorites</span>
                </Link>

                <Link
                    className="profile-link header-link"
                    to="/profile"
                    onClick={(e) => {
                        if (!userId) {
                            e.preventDefault();
                            setIsLoginOpen(true);
                        }
                    }}>
                    <img className="profile-icon" src="images/user.png" />

                </Link>
            </div>
            {isLoginOpen && (
                <div className="modal-overlay">
                    <div className="modal-box">
                        <h2>Login</h2>
                        <input 
                        type="text" 
                        placeholder="Email" 
                        className="modal-input email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                         />
                        <input 
                        type="password" 
                        placeholder="Password" 
                        className="modal-input password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)} />

                        <div className="modal-actions">
                            <button className="btn-submit" onClick={() => { handleLogin() }}>Login</button>
                            <button className="btn-submit" onClick={() => { handleSignUp()}}>Sign up</button>

                            <button className="btn-close" onClick={() => setIsLoginOpen(false)}>
                                Cancel
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    )
}