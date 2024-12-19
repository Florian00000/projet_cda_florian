import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchAllEvaluationsReadByAdmin, fetchAllEvaluationsNotReadByAdmin } from "./evaluationSlice"
import EvaluationRow from './EvaluationRow';

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
            <table>
                <thead>
                    <tr>
                        <th>liste des nouvelles évaluations</th>
                    </tr>
                </thead>
                <tbody>
                    {evluationsNotRead.map((evluation, index) => (
                        <EvaluationRow key={index} evaluation={evluation} isRead={false} />
                    ))}
                </tbody>
            </table>

            <table>
                <thead>
                    <tr>
                        <th>liste des anciennes évaluations</th>
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
