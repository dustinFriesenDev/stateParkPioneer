import React from "react";
import './Header.css';
import { Link } from "react-router-dom";

export default function Header() {
    return (
        <header>
            <nav>
                <ul className="navbar">
                    <li><Link to='/' className="btnLink">Home</Link></li>
                    <li><Link to='/about' className="btnLink">About</Link></li>
                    <li><Link to='/weather' className="btnLink">Weather</Link></li>
                    <li><Link to='/animals' className="btnLink">Animals</Link></li>
                    <li><Link to='/plants' className="btnLink">Plants</Link></li>
                    <li><Link to='http://discourse-trailblazer-forum.social' target="_blank" className="btnLink">Forum</Link></li>
                    <li><Link className="t-decoration" to='/trip'>Your Trips</Link></li>
                    <li><Link className="t-decoration" to='/profile'>Profile</Link></li> 
                    <li><Link to='login' className="btnLink">Log in</Link></li>                   
                </ul>
            </nav>
        </header>
    )
}