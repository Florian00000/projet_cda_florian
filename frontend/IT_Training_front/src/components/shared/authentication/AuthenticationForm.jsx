import React, { useRef } from 'react';
import Button from '../Button';
import { Link, useSearchParams } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { fetchLogin } from './authenticationSlice';

const AuthenticationForm = () => {

    const [searchParams, setSearchParams] = useSearchParams();
    const mode = searchParams.get("mode") ?? "login";
    const dispatch = useDispatch();

    const emailRef = useRef();
    const passwordRef = useRef();

    const handleForm = (e) => {
        e.preventDefault();

        const credentials = {
            email: emailRef.current.value,
            password: passwordRef.current.value
        }
        console.log(credentials);
        
        dispatch(fetchLogin(credentials))        
    }


    return (
        <main>
            <h2>Connexion à l'espace particulier</h2>
            <hr />
            <form onSubmit={handleForm}>
                <div>
                    <label htmlFor="email">email:</label>
                    <input type="email" id='email' required ref={emailRef}/>
                </div>
                <div>
                    <label htmlFor="password">mot de passe:</label>
                    <input type="password" id='password' required ref={passwordRef}/>
                </div>
                <Button type={"submit"} children={"Valider"}/>
            </form>
            <p>
                <span>Vous n'avez pas encore de compte?</span>
                <Link to={"/authentication?mode=register"}>S'inscire</Link>
            </p> 
            <hr />
            <Link to={"#"}>Connexion à l'espace entreprise</Link>
        </main>
    );
}

export default AuthenticationForm;
