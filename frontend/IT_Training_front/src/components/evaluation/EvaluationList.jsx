import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchAllEvaluationsReadByAdmin, fetchAllEvaluationsNotReadByAdmin } from "./evaluationSlice"
import EvaluationRow from './EvaluationRow';
import classes from "./evaluation.module.css"

const EvaluationList = () => {
    const dispatch = useDispatch();

    const { evluationsRead, evluationsNotRead } = useSelector((state) => state.evaluation);
    const { token } = useSelector((state) => state.authentication);

    const [selectedIds, setSelectedIds] = useState([]);

    const onCheckboxChange = (id, isSelected) => {
        if (isSelected) {
            setSelectedIds((prev) => [...prev, id]);
        }else{
            setSelectedIds((prev) => prev.filter((selectedIds) => selectedIds !== id));
        }
    }

    useEffect(() => {
        dispatch(fetchAllEvaluationsReadByAdmin(token))
        dispatch(fetchAllEvaluationsNotReadByAdmin(token))
    }, [dispatch, token])

    //partie pour vofir le tableau d id
    useEffect(() => {        
        console.log(selectedIds);
        
    }, [selectedIds])

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
                        <EvaluationRow key={index} evaluation={evluation} isRead={false} onCheckboxChange={onCheckboxChange} />
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
