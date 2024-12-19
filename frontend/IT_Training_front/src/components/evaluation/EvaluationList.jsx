import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchAllEvaluationsReadByAdmin, fetchAllEvaluationsNotReadByAdmin } from "./evaluationSlice"
import EvaluationRow from './EvaluationRow';
import classes from "./evaluation.module.css"

const EvaluationList = () => {
    const dispatch = useDispatch();

    const { evluationsRead, evluationsNotRead } = useSelector((state) => state.evaluation);
    const { token } = useSelector((state) => state.authentication);

    useEffect(() => {
        dispatch(fetchAllEvaluationsReadByAdmin(token))
        dispatch(fetchAllEvaluationsNotReadByAdmin(token))
    }, [dispatch, token])

    return (
        <main>
            <div>
                <h3>Liste des nouvelles évaluations</h3>
                <hr />
            </div>
            <table className={classes.tableEvaluation}>
                <thead>
                    <tr>
                        <th></th>
                        <th>date</th>
                        <th>centre</th>
                        <th>formateur</th>
                    </tr>
                </thead>
                <tbody>
                    {evluationsNotRead.map((evluation, index) => (
                        <EvaluationRow key={index} evaluation={evluation} isRead={false} />
                    ))}
                </tbody>
            </table>

            <div>
                <h3>Liste des anciennes évaluations</h3>
                <hr />
            </div>

            <table className={classes.tableEvaluation}>
            <thead>
                    <tr>
                        <th></th>
                        <th>date</th>
                        <th>centre</th>
                        <th>formateur</th>
                    </tr>
                </thead>
                <tbody>
                    {evluationsRead.map((evluation, index) => (
                        <EvaluationRow key={index} evaluation={evluation} isRead={true}  />
                    ))}
                </tbody>
            </table>

        </main>
    );
}

export default EvaluationList;
