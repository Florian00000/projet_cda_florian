import React from 'react';
import { Link } from 'react-router-dom';
import classes from "./Navbar.module.css"

const Navbar = () => {
    return (
        <nav className={classes.nav}>
            <Link to={"/"} className={classes.text}><span><b>IT-Training</b></span></Link>            
        </nav>
    );
}

export default Navbar;
