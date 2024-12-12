import React, { useEffect, useState } from 'react';
import StarsForm from '../shared/starsform/StarsForm';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { fetchSessionById } from '../training/trainingSlice';

const EvaluationForm = () => {
    const [rating, setRating] = useState(null);
    const [rating2, setRating2] = useState(null);
    const { idSession } = useParams();
    const dispatch = useDispatch();
    const session = useSelector((state) => state.training.sessions[0])

    useEffect(() => {
        dispatch(fetchSessionById(idSession));        
    }, [dispatch, idSession])


    return (
        <main>
            <div>
                <h2>Evaluation de la session</h2>
                <hr />
            </div>
            <p>test</p>
            <StarsForm rating={rating} onRatingChange={setRating}/>
            <p>la note {rating || "0"} </p>
            <p>test</p>
            <StarsForm rating={rating2} onRatingChange={setRating2}/>
            <p>la note {rating2 || "0"} </p>
        </main>
    );
}

export default EvaluationForm;
