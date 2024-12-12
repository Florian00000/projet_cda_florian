import React, { useEffect, useRef, useState } from 'react';
import StarsForm from '../shared/starsform/StarsForm';
import { useNavigate, useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { fetchSessionById } from '../training/trainingSlice';
import Button from '../shared/Button';
import { emptyEvaluationReturn, fetchAddEvaluation } from './evaluationSlice';
import Modal from '../shared/modal/Modal';

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
            <form>
                <div>
                    <h3>Evaluation du centre</h3>
                    <hr />
                </div>
                <div>
                    <div>
                        <p>qualité de l'accueil:</p>
                        <StarsForm rating={qualityReception} onRatingChange={setQualityReception} />
                    </div>
                    <hr />
                    <div>
                        <p>qualité de l'environnement: <br /> (salles, machines, repas...)</p>
                        <StarsForm rating={qualityEnvironment} onRatingChange={setQualityEnvironment} />
                    </div>
                </div>
                <div>
                    <h3>Evaluation du formateur</h3>
                    <hr />
                </div>
                <div>
                    <div>
                        <p>pédagogie:</p>
                        <StarsForm rating={pedagogy} onRatingChange={setPedagogy} />
                    </div>
                    <hr />
                    <div>
                        <p>maitrise  du domaine:</p>
                        <StarsForm rating={domainExpertise} onRatingChange={setDomainExpertise} />
                    </div>
                    <hr />
                    <div>
                        <p>disponibilité:</p>
                        <StarsForm rating={availability} onRatingChange={setAvailability} />
                    </div>
                    <hr />
                    <div>
                        <p>Réponses aux questions:</p>
                        <StarsForm rating={qualityResponses} onRatingChange={setQualityResponses} />
                    </div>
                </div>
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
                    <div >
                        <label htmlFor="description">Avez vous d'autres porjets de formations? </label>
                        <textarea id="description" rows={10} cols={30} ref={trainingProjectsRef}></textarea>
                    </div>

                </div>
                <Button children={"Envoyer"} type={"submit"} size={"medium"} onClick={handleSubmit} />

            </form>

        </main>
    );
}

export default EvaluationForm;
