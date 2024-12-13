import React, { useEffect, useRef, useState } from 'react';
import StarsForm from '../shared/starsform/StarsForm';
import { useNavigate, useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { fetchSessionById } from '../training/trainingSlice';
import Button from '../shared/Button';
import { emptyEvaluationReturn, fetchAddEvaluation } from './evaluationSlice';
import Modal from '../shared/modal/Modal';
import classes from "./evaluation.module.css"

const EvaluationForm = () => {
    const { idSession } = useParams();
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const session = useSelector((state) => state.training.sessions[0])
    const {user, token} = useSelector((state) => state.authentication)
    const {evaluationReturn} = useSelector((state) => state.evaluation);

    const [qualityReception, setQualityReception] = useState(null);
    const [qualityEnvironment, setQualityEnvironment] = useState(null);
    const [pedagogy, setPedagogy] = useState(null);
    const [domainExpertise, setDomainExpertise] = useState(null);
    const [availability, setAvailability] = useState(null);
    const [qualityResponses, setQualityResponses] = useState(null);
    const [technicalAnimations, setTechnicalAnimations] = useState(null);
    const [recommended, setRecommended] = useState(null);
    const trainingProjectsRef = useRef();

    useEffect(() => {
        dispatch(fetchSessionById(idSession));
    }, [dispatch, idSession])

    const handleSubmit = (event) => {
        event.preventDefault();

        if (
            qualityReception == null ||
            qualityEnvironment == null ||
            pedagogy == null ||
            domainExpertise == null ||
            availability == null ||
            qualityResponses == null ||
            technicalAnimations == null ||
            recommended == null
        ) {
            alert("Veuillez remplir tous les champs requis !");
            return;
        }
        const evaluation = {
            qualityReception: qualityReception,
            qualityEnvironment: qualityEnvironment,
            pedagogy: pedagogy,
            domainExpertise: domainExpertise,
            availability: availability,
            qualityResponses: qualityResponses,
            technicalAnimations: technicalAnimations,
            recommended: recommended,
            trainingProjects: trainingProjectsRef.current.value,
            idUser: user.userId,
            idSession: session.id
        }
        console.log(evaluation);
        const credetials = {
            evaluation: evaluation,
            token: token
        }
        trainingProjectsRef.current.value = "";
        dispatch(fetchAddEvaluation(credetials))
    }


    const closeModal = () => {
        if (evaluationReturn) {            
            navigate("/mySessions")
        }
        dispatch(emptyEvaluationReturn());       
        
    }

    return (
        <main>

            {evaluationReturn !== null && (
                <Modal changeModal={closeModal} buttonChildren={"ok"}>
                    <p> {evaluationReturn ? "Merci pour votre retour!": "Oups, un problème à eu lieu..."} </p>
                </Modal>
            )}

            <div>
                <h2>Evaluation de la session ({session?.startDate} au {session?.endDate})</h2>
                <hr />
            </div>
            <form className={classes.evaluationForm} >
                <div>
                    <h2 className={classes.blueText}>Evaluation du centre</h2>
                    <hr />
                </div>
                <div className={classes.dflexEvaluation}>
                    <div className={classes.flexStar} style={{width:"50%"}}>
                        <p>qualité de l'accueil:</p>
                        <StarsForm rating={qualityReception} onRatingChange={setQualityReception} />
                    </div>
                    <hr />
                    <div className={classes.flexStar} style={{width:"50%"}}>
                        <p>qualité de l'environnement: (salles, machines, repas...)</p>
                        <StarsForm rating={qualityEnvironment} onRatingChange={setQualityEnvironment} />
                    </div>
                </div>
                <div className={classes.blueText}>
                    <h2>Evaluation du formateur</h2>
                    <hr />
                </div>
                <div className={classes.dflexEvaluation}>
                    <div className={classes.flexStar} style={{width:"25%"}} >
                        <p>pédagogie:</p>
                        <StarsForm rating={pedagogy} onRatingChange={setPedagogy} />
                    </div>
                    <hr />
                    <div className={classes.flexStar} style={{width:"25%"}} >
                        <p>maitrise  du domaine:</p>
                        <StarsForm rating={domainExpertise} onRatingChange={setDomainExpertise} />
                    </div>
                    <hr />
                    <div className={classes.flexStar} style={{width:"25%"}} >
                        <p>disponibilité:</p>
                        <StarsForm rating={availability} onRatingChange={setAvailability} />
                    </div>
                    <hr />
                    <div className={classes.flexStar} style={{width:"25%"}} >
                        <p>Réponses aux questions:</p>
                        <StarsForm rating={qualityResponses} onRatingChange={setQualityResponses} />
                    </div>
                </div>
                <div className={classes.dflex}>
                    <div>
                        <div>
                            <p>techniques d'animations:</p>
                            <StarsForm rating={technicalAnimations} onRatingChange={setTechnicalAnimations} />
                        </div>
                        <div>
                            <p>Recommandez vous la formation?</p>
                            <div>
                                <input type="radio" name="recommanded" id="isrecommanded" value={true} onChange={() => setRecommended(true)} checked={recommended === true} required />
                                <label htmlFor="isrecommanded">oui</label>
                            </div>
                            <div>
                                <input type="radio" name="recommanded" id="notrecommanded" value={false} onChange={() => setRecommended(false)} checked={recommended === false} required />
                                <label htmlFor="notrecommanded">non</label>
                            </div>

                        </div>
                    </div>
                   
                    <div className={classes.trainingProjects} >
                        <label htmlFor="trainingProjects">Avez vous d'autres projets de formations? </label>
                        <textarea id="trainingProjects" rows={10} cols={30} ref={trainingProjectsRef}></textarea>
                        <div className={classes.divButtonSubmit}>
                            <Button children={"Envoyer"} type={"submit"} size={"medium"} onClick={handleSubmit} />
                        </div>
                    </div>
                </div>             

            </form>

        </main>
    );
}

export default EvaluationForm;
