import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useLocation, useNavigate } from 'react-router-dom';
import { fetchAddNote } from './testUserSlice';
import Button from '../shared/Button';
import classes from "./TestUser.module.css"

const ResultTest = () => {
    const location = useLocation();
    const dispatch = useDispatch();
    const { testPassed, finalScore, testUser } = location.state;
    const { token, user } = useSelector((state) => state.authentication);
    const { training } = useSelector((state) => state.training)
    const navigate = useNavigate()

    useEffect(() => {
        if (token && testUser) {
            const note = {
                result: +finalScore,
                success: testPassed,
                testUserId: testUser.id,
                userId: user.userId
            }
            console.log(note);

            //Reprendre ici, vérifier la fonction!!
            //dispatch(fetchAddNote(note, token))
        }

    }, [token, testUser, testPassed, finalScore, dispatch])

    const redirectToTraining = () => {
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
                <Button onClick={redirectToTraining} children={"OK"}></Button>
            </section>

        </main>
    );
}

export default ResultTest;
