import React, { useState } from 'react';
import StarsForm from '../shared/starsform/StarsForm';

const EvaluationForm = () => {
    const [rating, setRating] = useState(null);
    const [rating2, setRating2] = useState(null);


    return (
        <div>
            <p>test</p>
            <StarsForm rating={rating} onRatingChange={setRating}/>
            <p>la note {rating || "0"} </p>
            <p>test</p>
            <StarsForm rating={rating2} onRatingChange={setRating2}/>
            <p>la note {rating2 || "0"} </p>
        </div>
    );
}

export default EvaluationForm;
