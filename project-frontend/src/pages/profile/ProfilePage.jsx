import { Header } from "../../components/Header"
import "./ProfilePage.css"
import { useNavigate } from "react-router-dom"
import { useState } from "react";
import axios from "axios";

export function ProfilePage({ isLoginOpen, setIsLoginOpen, userId, setUserId }) {
    const [isEmailOpen, setIsEmailOpen] = useState(false);
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [passwordRep, setPasswordRep] = useState('');
    const [isPasswordOpen, setIsPasswordOpen] = useState(false);    
    const [isDeleteOpen, setIsDeleteOpen] = useState(false);
    const navigate = useNavigate();
    const handleLogOff = async () => {
            try{
            const response = await axios.post('http://localhost:8080/api/v1/auth/logout')
            setUserId(null)
            navigate("/")
            }
            catch(error){
                console.error("Błąd podczas wylogowania:", error);
            alert("Nie udało się wylogować. Spróbuj ponownie.");
            }

        } 
    const handleDeleteProfile = async () => {
            try{
            const response = await axios.delete(`http://localhost:8080/api/v1/auth/${userId}`)
            await axios.post('http://localhost:8080/api/v1/auth/logout')
            setUserId(null)
            navigate("/")
            }
            catch(error){
                console.error("Błąd podczas usuwania konta:", error);
            alert("Nie udało się usunąć kąta. Spróbuj ponownie.");
            }

        } 
    
    const handleChangeEmail = async () => {
            try{
            const response = await axios.put(`http://localhost:8080/api/v1/auth/${userId}/email`,{
                "Email": email
            })
            setEmail('')
            setIsEmailOpen(false)
            
            }
            catch(error){
                console.error("Błąd podczas wylogowania:", error);
            alert("Nie udało się wylogować. Spróbuj ponownie.");
            }

        }

    const handleChangePassword = async () => {
            try{
            if(!(password === passwordRep)){
                alert("hasła się nie zgadzają")
                return
            }
            const response = await axios.put(`http://localhost:8080/api/v1/auth/${userId}/password`,{
                "PasswordHash": password
            })
            setPassword('')
            setPasswordRep('')
            setIsPasswordOpen(false)
            
            }
            catch(error){
                console.error("Błąd podczas wylogowania:", error);
            alert("Nie udało się wylogować. Spróbuj ponownie.");
            }

        } 




    return (
        <>
            <title>Wyszukiwarka Lotów</title>

            <Header isLoginOpen={isLoginOpen}
                setIsLoginOpen={setIsLoginOpen}
                userId={userId}
                setUserId={setUserId} />

            <div className="profile-page">
                <p className="text">Profile</p>
                <div className="divider">
                    <button className="change-button"
                        onClick={() => {setIsEmailOpen(true)}}
                    >Change email</button>
                </div>
                <div className="divider">
                    <button className="change-button"
                        onClick={() => {setIsPasswordOpen(true)}}
                    >Change password</button>
                </div>
                <div className="divider">
                    <button className="change-button logOff-button" onClick={() => handleLogOff()}>Log off</button>
                </div>
                <div className="divider">
                    <button className="change-button logOff-button" onClick={() => setIsDeleteOpen(true)}>Delete profile</button>
                </div>

                 {isEmailOpen && (
                <div className="modal-overlay">
                    <div className="modal-box">
                        <h2>Change Email</h2>
                        <input 
                        type="text" 
                        placeholder="NewEmail" 
                        className="modal-input"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                         />

                        <div className="modal-actions">
                            <button className="btn-submit" onClick={() => { handleChangeEmail() }}>Change Email</button>

                            <button className="btn-close" onClick={() => setIsEmailOpen(false)}>
                                Cancel
                            </button>
                        </div>
                    </div>
                </div>
            )}

            {isPasswordOpen && (
                <div className="modal-overlay">
                    <div className="modal-box">
                        <h2>Change Password</h2>
                        <input 
                        type="password" 
                        placeholder="NewPassword" 
                        className="modal-input"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                         />
                        <input 
                        type="password" 
                        placeholder="RepeatNewPassword" 
                        className="modal-input"
                        value={passwordRep}
                        onChange={(e) => setPasswordRep(e.target.value)}
                         />

                        <div className="modal-actions">
                            <button className="btn-submit" onClick={() => { handleChangePassword() }}>Change Password</button>

                            <button className="btn-close" onClick={() => setIsPasswordOpen(false)}>
                                Cancel
                            </button>
                        </div>
                    </div>
                </div>
            )}

            {isDeleteOpen && (
                <div className="modal-overlay">
                    <div className="modal-box">
                        <h2>Delete Profile</h2>

                        <div className="modal-actions">
                            <button className="btn-delete" onClick={() => { handleDeleteProfile()}}>Delete Profile</button>

                            <button className="btn-submit" onClick={() => setIsDeleteOpen(false)}>
                                Cancel
                            </button>
                        </div>
                    </div>
                </div>
            )}
            </div>

           
        </>
    )
}