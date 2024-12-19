import React, { useEffect } from 'react';
import { formatDateToFrench } from '../../utils/methodsDate';
import { BASE_URL } from '../../utils/constant';
import { useDispatch, useSelector } from 'react-redux';
import Button from '../shared/Button';
import axios from 'axios';
import { fetchAllEvaluationsNotReadByAdmin, fetchAllEvaluationsReadByAdmin } from './evaluationSlice';

const EvaluationModal = ({evaluation, setOpenModal}) => {
    const { token } = useSelector((state) => state.authentication)
    const dispacth = useDispatch();

    const fetchReadByAdmin = async () => {
        try {
            const response = await axios.patch(`${BASE_URL}admin/evaluation/${evaluation?.id}/readByAdmin`,
                {},
                {headers: {
                    "Authorization": `Bearer ${token}`
                }}
            )
            console.log(response.data)
        } catch (error) {
            const serializedError = error.response?.data || { message: error.message };
            console.log(serializedError);            
        }
        setOpenModal(false)
        dispacth(fetchAllEvaluationsReadByAdmin(token))
        dispacth(fetchAllEvaluationsNotReadByAdmin(token))
    } 

    return (
        <div style={{textAlign:"left"}}>            
            <p style={{textAlign:"right"}}>{ formatDateToFrench(evaluation.valuationDate)}</p>
            <hr/>
            <p> qualité de la réception:{evaluation.qualityReception}</p>
            <p>qualité de l'environnement : {evaluation.qualityEnvironment}</p>
            <p>qualité de la pédagogie : {evaluation.pedagogy}</p>
            <p>domaine d'expertise : {evaluation.domainExpertise}</p>
            <p>disponibilité du formateur : {evaluation.availability}</p>
            <p>qualité des réponses du formateur : {evaluation.qualityResponses}</p>
            <p>qualité de la technique d'animation : {evaluation.technicalAnimations}</p>

            <hr style={{width:"50%"}} />
            <p>{evaluation.recommended ? "recommande la formation" : "ne recommande pas la formation"}</p>
            {evaluation?.trainingProjects &&  <p>projets futurs: {evaluation.trainingProjects}</p> }
            <Button children={"marquer comme lu"} onClick={fetchReadByAdmin}/>
           
        </div>
    );
}

export default EvaluationModal;
