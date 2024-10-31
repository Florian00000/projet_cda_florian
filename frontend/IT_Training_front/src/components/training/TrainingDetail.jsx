import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchTrainingById } from './trainingSlice';
import { useParams } from 'react-router-dom';
import Markdown from 'react-markdown'
import remarkGfm from 'remark-gfm'
import classes from './Training.module.css'

const TrainingDetail = () => {
    const dispatch = useDispatch();
    const { idTraining } = useParams();
    const training = useSelector((state) => state.training.training)

    useEffect(() => {
        dispatch(fetchTrainingById(idTraining));
    }, [idTraining, dispatch])

    return (
        <main>
              
            {training ? (
                <>
                    <div>
                        <h2> {training.title} </h2>
                        <hr />
                    </div>
                    
                    <div className={classes.listSubThemes}>
                        {training.subThemes.map((subTheme, index) => (
                        <span key={index}>{subTheme.title}</span>
                        ))}
                    </div>
                    

                    <div>
                        <Markdown remarkPlugins={[remarkGfm]}>{training.description}</Markdown>
                    </div>
                    {training.price && (<p> {training.price} </p>)}
                 </>
            ) : (

                <p>Chargement des détails de la formation...</p> 
            )}
        </main>
    );
}

export default TrainingDetail;
