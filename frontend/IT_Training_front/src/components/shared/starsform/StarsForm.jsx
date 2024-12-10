import React, { useState } from 'react';
import './starsForm.css';

const StarsForm = ({rating, onRatingChange}) => {

    const [hover, setHover] = useState(null);
    const totalStars = 5;

    return (
        <div>

            {[...Array(totalStars)].map((star, index) => {
                const currentRating = index + 1;

                return (
                    <label key={index}>
                        <input
                            type="radio"
                            name="rating"
                            value={currentRating}
                            onChange={() => onRatingChange(currentRating)}
                            className='inputStar'
                        />
                        <span
                            className="spanStar"
                            style={{
                                color:
                                    currentRating <= (hover || rating) ? "#ffc107" : "var(--greyCard)"
                            }}
                            onMouseEnter={() => setHover(currentRating)}
                            onMouseLeave={() => setHover(null)}
                        >
                            &#9733;
                        </span>
                    </label>
                );
            })}

        </div>
    );
}

export default StarsForm;
