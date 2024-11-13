import React, { useEffect, useRef, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";
import { fetchQuestionById, fetchTestUserById } from "./testUserSlice";
import Button from "../shared/Button";
import classes from "./TestUser.module.css"

const TestUser = () => {
    const dispatch = useDispatch();
    const { idTestUser } = useParams();
    const navigate = useNavigate();
    const testUser = useSelector((state) => state.testUser.testUser);
    const testQuestion = useSelector((state) => state.testUser.question);
    const [questionNumber, setQuestionNumber] = useState(0);
    const [selectedAnswer, setSelectedAnswer] = useState(null);
    const [score, setScore] = useState(0);

    useEffect(() => {
        dispatch(fetchTestUserById(idTestUser));
    }, [idTestUser, dispatch]);

    useEffect(() => {
        if (testUser && testUser.questions) {
            dispatch(fetchQuestionById(testUser.questions[questionNumber].id));
            setSelectedAnswer(null);
        }
    }, [questionNumber, dispatch, testUser]);

    const handleAnswerChange = (event) => {
        setSelectedAnswer(event.target.value);
    };

    const validateAnswer = () => {
    
        const isCorrect = selectedAnswer === testQuestion.answer
        const updatedScore = isCorrect ? score + 1 : score;

        if (testUser && questionNumber < testUser.questions.length - 1) {
            if(isCorrect) setScore(updatedScore);
            setQuestionNumber((prevNumber) => prevNumber + 1);
        } else {
            const testPassed = updatedScore >= testUser.expectedResult;
            navigate(`/training/testUser/result`, {
                state: {
                    testPassed,
                    finalScore: updatedScore
                }
            })
        };
    };

    return (
        <main>
            {testQuestion ? (
                <>
                    <article className={classes.articleTitle}>
                        <div>
                            <h2> Test des prérequis </h2>
                            <hr />
                        </div>
                    </article>

                    <section>
                        <article className={classes.articleQuestion}>
                            <h3>Question:</h3>
                            <p>{testQuestion.label} </p>
                        </article>
                        <article className={classes.articleQuestion}>
                            <h3>Réponses possibles: </h3>
                            {testQuestion.propositions.map((proposition, index) => (
                                <div key={index}>
                                    <input
                                        type="radio"
                                        name="question"
                                        id={proposition.id}
                                        value={proposition.option}
                                        onChange={handleAnswerChange}
                                        checked={selectedAnswer === proposition.option}
                                    />
                                    <label htmlFor={proposition.id}>{proposition.option}</label>
                                </div>
                            ))}
                        </article>
                        <article className={classes.articleBottom}>
                            <p>
                                Question <span className={classes.numberQuestion} >{questionNumber + 1}</span> /{" "}
                                {testUser.questions.length}{" "}
                            </p>
                            <Button                                
                                children={questionNumber < testUser.questions.length - 1 ? "Valider ma réponse"  : "Valider le Test"}
                                onClick={validateAnswer}
                                disabled={!selectedAnswer}
                            ></Button>
                        </article>
                    </section>


                </>
            ) : (
                <p>Chargement du questionnaire</p>
            )}
        </main>
    );
};
export default TestUser;
