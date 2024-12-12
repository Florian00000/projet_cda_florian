import React, { useEffect, useState } from 'react';
import StarsForm from '../shared/starsform/StarsForm';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { fetchSessionById } from '../training/trainingSlice';

const EvaluationForm = () => {
    const { idSession } = useParams();
    const dispatch = useDispatch();
    const session = useSelector((state) => state.training.sessions[0])

    const [qualityReception, setQualityReception] = useState(null);
    const [qualityEnvironment, setQualityEnvironment] = useState(null);
    const [pedagogy, setPedagogy] = useState(null);
    const [domainExpertise, setDomainExpertise] = useState(null);
    const [qualityResponses, setQualityResponses] = useState(null);
    const [technicalAnimations, setTechnicalAnimations] = useState(null);
    const [recommended, setRecommended] = useState(null);

    useEffect(() => {
        dispatch(fetchSessionById(idSession));
    }, [dispatch, idSession])


    return (
        <main>
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
                        <StarsForm rating={pedagogy} onRatingChange={setPedagogy} />
                    </div>
                    <div>
                        <p>pédagogie:</p>
                        <StarsForm rating={pedagogy} onRatingChange={setPedagogy} />
                    </div>
                </div>

            </form>

        </main>
    );
}

export default EvaluationForm;
