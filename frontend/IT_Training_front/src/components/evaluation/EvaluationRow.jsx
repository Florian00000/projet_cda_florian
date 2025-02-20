import React, { useEffect, useState } from 'react';
import { formatDateToFrench } from '../../utils/methodsDate';
import classes from "./evaluation.module.css"
import ModalButtonless from '../shared/modal/ModalButtonless';
import EvaluationModal from './EvaluationModal';


const EvaluationRow = ({ evaluation, isRead, onCheckboxChange, selectedIds }) => {

    const [avgRateCenter, setAvgRateCenter] = useState(0);
    const [avgRateTrainer, setAvgRateTrainer] = useState(0);
    const [opdenModal, setOpenModal] = useState(false);

    const alert = (evaluation.qualityReception || evaluation.qualityEnvironment || evaluation.pedagogy || evaluation.domainExpertise
        || evaluation.availability || evaluation.qualityResponses || evaluation.technicalAnimations) < 3 

    useEffect(() => {
        const scoreCenter = [
            evaluation.qualityReception,
            evaluation.qualityEnvironment
        ];
        const scoreTrainer = [
            evaluation.pedagogy,
            evaluation.domainExpertise,
            evaluation.availability,
            evaluation.qualityResponses,
            evaluation.technicalAnimations
        ];
        const totalCenter = scoreCenter.reduce((acc, value) => acc + value, 0)
        const totalTrainer = scoreTrainer.reduce((acc, value) => acc + value, 0)
        setAvgRateCenter(totalCenter / scoreCenter.length)
        setAvgRateTrainer(totalTrainer / scoreTrainer.length)  
    }, [evaluation])

    const handleCheckboxChange = (event) => {
        const checked = event.target.checked;
        onCheckboxChange(evaluation.id, checked)
    }

    return (
        <>
            {opdenModal && 
            <ModalButtonless changeModal={() => setOpenModal(false)}>
                <EvaluationModal evaluation={evaluation} setOpenModal={setOpenModal}/>
            </ModalButtonless>
            }           

            <tr className={ alert ? classes.trBorderAlert : classes.trBorder} >
                <td ><input type="checkbox" disabled={isRead} checked={selectedIds && selectedIds.includes(evaluation.id)} onChange={handleCheckboxChange} /></td>
                <td onClick={() => setOpenModal(true)} >{formatDateToFrench(evaluation?.valuationDate)}</td>
                <td onClick={() => setOpenModal(true)}>{avgRateCenter.toFixed(2)} </td>
                <td onClick={() => setOpenModal(true)}>{avgRateTrainer.toFixed(2)} </td>
            </tr>
        </>
    );
}

export default EvaluationRow;
