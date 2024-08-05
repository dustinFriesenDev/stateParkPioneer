import './App.css';
import { Routes, Route } from 'react-router-dom';
import Header from './components/nav/Header.js';
import Home from './components/pages/Home.js'
import Animals from './components/pages/animals/Animals.js';
import Plants from './components/pages/plants/Plants.js';
import Weather from './components/pages/Weather.js';
import About from './components/pages/about/About.js';
import Trip from './components/pages/Trip.js';
import LoginButton from './components/auth/LoginButton.js';
import LogoutButton from './components/auth/LogoutButton.js';
import Profile from './components/auth/Profile.js';
import Footer from './components/nav/Footer.js';
import './components/nav/Header.css';
import './components/auth/Auth.css';

function App() {
  
  return (
    <main>
      <Header/>
      <Routes>
        <Route exact path='/' element={<Home />} />
        <Route path='/about' element={<About/>} />
        <Route path='/weather' element={<Weather/>} />
        <Route path='/animals' element={<Animals/>} /> 
        <Route path='/plants' element={<Plants/>} />
        <Route path='/trip' element={<Trip/>} />
        <Route path='/profile' element={<Profile/>} />
      </Routes>
      <Footer />
      <LoginButton/>
      <LogoutButton/>
    </main>
  );
}

export default App;


