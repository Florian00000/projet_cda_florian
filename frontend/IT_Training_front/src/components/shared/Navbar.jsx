import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import classes from "./Navbar.module.css"
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faSortDown } from '@fortawesome/free-solid-svg-icons'

const Navbar = () => {
    const [isDropdownVisible, setDropdownVisible] = useState(false);

    const toggleDopdown = () => {
        setDropdownVisible(!isDropdownVisible)
    };

    return (
        <nav className={classes.nav}>
            <Link to={"/"} className={classes.textIt}><span><b>IT-Training</b></span></Link>   
            <div className={classes.menu} onMouseEnter={toggleDopdown} onMouseLeave={toggleDopdown}>
                <span className={classes.menuTitle} >Formations</span>
                <span>
                    <FontAwesomeIcon icon={faSortDown} />  
                </span>
                    
                                
                {isDropdownVisible && (
                    <div className={classes.dropdown} >
                        <Link to={"/training/admin/addTraining"} className={classes.dropdownItem} >Ajouter Formation</Link>
                        <Link to={"#"} className={classes.dropdownItem} >test</Link>
                        <Link to={"#"} className={classes.dropdownItem} >test</Link>
                    </div>
                )}
            </div>         
        </nav>
    );
}

export default Navbar;
