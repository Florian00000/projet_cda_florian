import React, { useEffect, useRef, useState } from 'react';
import Button from '../Button';
import { Link, useNavigate, useSearchParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { emptyError, fetchLogin, fetchRegister } from './authenticationSlice';
import Modal from '../modal/Modal';
import classes from "./Authentication.module.css"

const AuthenticationForm = () => {

    const [searchParams, setSearchParams] = useSearchParams();
    const mode = searchParams.get("mode") ?? "login";
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const { token, error } = useSelector((state) => state.authentication);
    const [passwordDiff, setPasswordDiff] = useState(false);

    const firstnameRef = useRef();
    const lastnameRef = useRef();
    const emailRef = useRef();
    const passwordRef = useRef();
    const passwordRef2 = useRef();

    const handleForm = (e) => {
        e.preventDefault();

        const credentials = {
            email: emailRef.current.value,
            password: passwordRef.current.value
        }

        if (mode === "login") {
            console.log(credentials);
            dispatch(fetchLogin(credentials))
        } else {
            credentials.firstName = firstnameRef.current.value;
            credentials.lastName = lastnameRef.current.value;

            if (passwordRef.current.value === passwordRef2.current.value) {
                setPasswordDiff(false);
                dispatch(fetchRegister(credentials))
            } else {
                setPasswordDiff(true);
            }
        }
    }

    useEffect(() => {
        if (token) {
            navigate("/")
        }
    }, [token])

    const closeModal = () => {
        if (mode === "login") {
            emailRef.current.value = "";
            passwordRef.current.value = "";
        }else{
            emailRef.current.value = "";
            passwordRef.current.value = "";
            firstnameRef.current.value = "";
            lastnameRef.current.value = "";
            passwordRef2.current.value = "";
        }
        dispatch(emptyError())
    }

    return (
        <main className={classes.mainForm}>

            {error && (
                <Modal changeModal={closeModal} buttonChildren={"ok"}>
                    {"Mot de passe ou email invalide"}
                </Modal>
            )}

            <section className={classes.sectionForm}>
                <h2> {mode === "login" ? "Connexion à l'espace particulier" : "Inscription à l'espace particulier"} </h2>
                <hr className={classes.hrTitle}/>
                <form onSubmit={handleForm}>
                    {mode === "register" && (
                        <div className={classes.blockName}>
                            <div >
                                <label htmlFor="firstname">Prénom:</label>
                                <input type="text" id='firstname' required ref={firstnameRef} />
                            </div>

                            <div >
                                <label htmlFor="lastname">Nom de famille:</label>
                                <input type="text" id='lastname' required ref={lastnameRef} />
                            </div>
                        </div>

                    )}

                    <div className={classes.inputBlock}>
                        <label htmlFor="email">email:</label>
                        <input type="email" id='email' required ref={emailRef} />
                    </div>
                    <div className={classes.inputBlock}>
                        <label htmlFor="password">mot de passe:</label>
                        <input type="password" id='password' required ref={passwordRef} />
                    </div>

                    {mode === "register" && (
                        <div className={classes.inputBlock}>
                            <label htmlFor="password2">Confirmez le mot de passe</label>
                            <input type="password" id='password2' required ref={passwordRef2} />
                            {passwordDiff && <p>Erreur avec la confirmation du mot de passe</p>}
                        </div>

                    )}

                    <div className={classes.divButton}>
                        <Button type={"submit"} children={mode === "login" ? "Connexion" : "Inscription"} />
                    </div>
                </form>
                {mode === "login" ? 
                (<p>
                    <span>Vous n'avez pas encore de compte? </span>
                    <Link to={"/authentication?mode=register"}>S'inscrire</Link>
                </p>):
                (<p>
                    <span>Vous avez déjà un compte? </span>
                    <Link to={"/authentication?mode=login"}>Se connecter</Link>
                </p>)    
            }

                
                <hr />
                <Link >Connexion à l'espace entreprise</Link>
            </section>


        </main>
    );
}

export default AuthenticationForm;
