import React from 'react';
import { useLocation } from 'react-router-dom';

const ResultTest = () => {
    const location = useLocation();
    const { testPassed, finalScore} = location.state;

    return (
        <div>
            <h2>Résultat du test</h2>
            {testPassed ? (
                <p>Félicitations ! Vous avez réussi le test avec un score de {finalScore}.</p>
            ) : (
                <p>Dommage, vous n'avez pas atteint le score requis. Votre score est de {finalScore}.</p>
            )}
        </div>
    );
}

export default ResultTest;
