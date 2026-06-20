//import { useState } from 'react'
import { Routes, Route } from 'react-router'
import { HomePage } from './pages/home/HomePage'
import { ProfilePage } from './pages/profile/ProfilePage'
import { FavoritesPage } from './pages/favorites/FavoritesPage'
import { useState } from 'react'

import './App.css'

function App() {
  //const [count, setCount] = useState(0)

  const [isLoginOpen, setIsLoginOpen] = useState(false);
  const [userId, setUserId] = useState(null);

  return (
    <Routes>
      <Route index element={<HomePage isLoginOpen={isLoginOpen}
        setIsLoginOpen={setIsLoginOpen}
        userId={userId}
        setUserId={setUserId} />} />
      <Route path="profile" element={<ProfilePage isLoginOpen={isLoginOpen}
        setIsLoginOpen={setIsLoginOpen}
        userId={userId}
        setUserId={setUserId} />} />
      <Route path="favorites" element={<FavoritesPage isLoginOpen={isLoginOpen}
        setIsLoginOpen={setIsLoginOpen}
        userId={userId}
        setUserId={setUserId} />} />
    </Routes>
  )
}

export default App
