import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useLocation, useNavigate } from 'react-router-dom';
import { fetchAddNote } from './testUserSlice';
import Button from '../shared/Button';
import classes from "./TestUser.module.css"

const ResultTest = () => {
    const location = useLocation();
    const dispatch = useDispatch();
    const { testPassed, finalScore, testUser, training } = location.state;
    const { token, user } = useSelector((state) => state.authentication);
    const navigate = useNavigate();
    const [credentials, setCredentials] = useState(null);

    useEffect(() => {    
            
        if (token && testUser) {
            const note = {
                result: +finalScore,
                success: testPassed,
                testUserId: testUser.id,
                userId: user.userId
            };
            setCredentials({ note, token });            
            
        }

    }, [token, testUser, testPassed, finalScore, dispatch, user.userId])

    const redirectToTraining = () => {
        dispatch(fetchAddNote(credentials))
        navigate(`/training/${training.id}`)
    }

    return (
        <main>
            <section className={classes.sectionResultTest}>
                <h2>Résultat du test</h2>
                {testPassed ? (
                    <p>Félicitations ! Vous avez réussi le test avec un score de {finalScore}.</p>
                ) : (
                    <p>Dommage, vous n'avez pas atteint le score requis. Votre score final est de {finalScore}.</p>
                )}
                <Button onClick={redirectToTraining} children={"OK"} disabled={credentials === null}></Button>
            </section>

        </main>
    );
}

export default ResultTest;
