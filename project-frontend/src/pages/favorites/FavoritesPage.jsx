import { Header } from "../../components/Header"
import './FavoritesPage.css'

export function FavoritesPage({ isLoginOpen, setIsLoginOpen, userId, setUserId }) {




    return (
        <>
            <title>Wyszukiwarka Lotów</title>

            <Header isLoginOpen={isLoginOpen}
                setIsLoginOpen={setIsLoginOpen}
                userId={userId}
                setUserId={setUserId} />

            <div className="favorites-page">
                <p className="text">Favorites</p>
                <div className="favorites-container">

                </div>
            </div>
        </>
    )
}