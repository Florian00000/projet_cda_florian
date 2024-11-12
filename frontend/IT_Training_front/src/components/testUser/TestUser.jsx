import React, { useEffect, useRef, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";
import { fetchQuestionById, fetchTestUserById } from "./testUserSlice";
import Button from "../shared/Button";

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
        // if (testUser && selectedAnswer == testQuestion.answer) {
        //     setScore((prevNumber) => prevNumber + 1);
        // }

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
                    <article>
                        <div>
                            <h2> Test des prérequis </h2>
                            <hr />
                        </div>
                    </article>

                    <section>
                        <article>
                            <h3>Question:</h3>
                            <p>{testQuestion.label} </p>
                        </article>
                        <article>
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
                        <article>
                            <p>
                                Question <span>{questionNumber + 1}</span> /{" "}
                                {testUser.questions.length}{" "}
                            </p>
                            <Button
                                children={"Valider ma réponse"}
                                onClick={validateAnswer}
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
