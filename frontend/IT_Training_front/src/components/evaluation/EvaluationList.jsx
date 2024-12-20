import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchAllEvaluationsReadByAdmin, fetchAllEvaluationsNotReadByAdmin } from "./evaluationSlice"
import EvaluationRow from './EvaluationRow';
import classes from "./evaluation.module.css"
import Button from '../shared/Button';
import { BASE_URL } from '../../utils/constant';
import axios from 'axios';

const EvaluationList = () => {
    const dispatch = useDispatch();

    const { evluationsRead, evluationsNotRead } = useSelector((state) => state.evaluation);
    const { token } = useSelector((state) => state.authentication);

    const [selectedIds, setSelectedIds] = useState([]);

    const onCheckboxChange = (id, isSelected) => {
        if (isSelected) {
            setSelectedIds((prev) => [...prev, id]);
        } else {
            setSelectedIds((prev) => prev.filter((selectedIds) => selectedIds !== id));
        }
    }

    useEffect(() => {
        dispatch(fetchAllEvaluationsReadByAdmin(token))
        dispatch(fetchAllEvaluationsNotReadByAdmin(token))
    }, [dispatch, token])

    const readByAdminMultiple = async(list) => {
        try {
            const response = await axios.patch(`${BASE_URL}admin/evaluation/list/readByAdmin`,
                {strings: list},
                {headers: {
                    "Authorization": `Bearer ${token}`
                }}
            )
            console.log(response.data)
        } catch (error) {
            const serializedError = error.response?.data || { message: error.message };
            console.log(serializedError);
        }
    }

    const handleButtonRead = async () => {
        if (!selectedIds ||selectedIds.length === 0) {
            console.log("pas d'éléments selectionnés");
            return            
        }
        await readByAdminMultiple(selectedIds);
        dispatch(fetchAllEvaluationsReadByAdmin(token))
        dispatch(fetchAllEvaluationsNotReadByAdmin(token))
        setSelectedIds([])
    }

    return (
        <main>
            <div style={{ marginLeft: "auto", marginTop: "20px" }}>
                <Button children={"marquer comme lu"} onClick={handleButtonRead} disabled={!selectedIds || selectedIds.length == 0} />
            </div>


            <div >
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
                        <EvaluationRow key={index} evaluation={evluation} isRead={true} />
                    ))}
                </tbody>
            </table>

        </main>
    );
}

export default EvaluationList;
