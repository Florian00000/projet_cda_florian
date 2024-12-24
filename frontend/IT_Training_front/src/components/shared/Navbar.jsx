import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import classes from "./Navbar.module.css"
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faSortDown, faBell, faBellSlash } from '@fortawesome/free-solid-svg-icons'
import { useDispatch, useSelector } from 'react-redux';
import { emptyAlert, logout, triggerAlert } from './authentication/authenticationSlice';
import { fetchAllEvaluationsNotReadByAdmin } from '../evaluation/evaluationSlice';

const Navbar = () => {
    const [isDropdownVisible, setDropdownVisible] = useState(false);
    const [isDropdownVisibleMySpace, setDropdownVisibleMySpace] = useState(false);
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const { token, user, alert, searchAlert } = useSelector((state) => state.authentication);
    const { evluationsNotRead } = useSelector((state) => state.evaluation);

    const toggleDopdown = () => {
        setDropdownVisible(!isDropdownVisible)
    };

    const toggleDopdownMySpace = () => {
        setDropdownVisibleMySpace(!isDropdownVisibleMySpace)
    }

    useEffect(() => {
        if (user?.roles.split(",").includes("ROLE_ADMIN")) {
            dispatch(fetchAllEvaluationsNotReadByAdmin(token))
        }
    }, [user])


    useEffect(() => {
        if ((user?.roles.split(",").includes("ROLE_ADMIN")) && (evluationsNotRead && evluationsNotRead.length > 1)) {
            const hasLowScore = evluationsNotRead.some(evaluation => {
                const scores = [evaluation.qualityReception, evaluation.qualityEnvironment, evaluation.pedagogy, evaluation.domainExpertise, 
                evaluation.availability, evaluation.qualityResponses, evaluation.technicalAnimations];
                return scores.some(score => score < 3)
            })

            if (hasLowScore) {
                dispatch(triggerAlert())
            }else{
                dispatch(emptyAlert())
            }
        }else {
            dispatch(emptyAlert())
        }


    }, [evluationsNotRead, searchAlert])

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
                        <Link to={"/"} className={classes.dropdownItem} >Domaines proposés</Link>
                        {user && user?.roles.split(",").includes("ROLE_ADMIN") &&
                            (<>
                                <Link to={"/training/admin/addTraining"} className={classes.dropdownItem} >Ajouter Formation</Link>
                                <Link to={"/evaluation/list"} className={classes.dropdownItem} >Évaluations</Link>
                            </>
                            )}


                    </div>
                )}
            </div>

            {token &&
                <div className={classes.menu} onMouseEnter={toggleDopdownMySpace} onMouseLeave={toggleDopdownMySpace}>
                    <span className={classes.menuTitle} >Mon Espace Personnel</span>
                    <span>
                        <FontAwesomeIcon icon={faSortDown} />
                    </span>


                    {isDropdownVisibleMySpace && (
                        <div className={classes.dropdown} >
                            <Link to={"/mySessions"} className={classes.dropdownItem} style={{ width: "22dvh" }} >Mes Sessions</Link>
                        </div>
                    )}
                </div>
            }


            {token ?
                <div className={classes.divLoginButton}>
                    <p className={classes.username}> {user.sub.split("@")[0]} </p>
                    <div style={{marginRight: "20px", color: "var(--darkpurple)"}}>
                        < FontAwesomeIcon icon={alert ? faBell : faBellSlash} />
                    </div>
                    <button className={classes.loginButton} onClick={() => dispatch(logout())}>Se déconnecter</button>
                </div>

                : <button className={classes.loginButton} onClick={() => navigate("/authentication")}>Se connecter</button>}



        </nav>
    );
}

export default Navbar;
