import React, { useRef, useState } from 'react';
import Button from '../shared/Button';
import { useDispatch } from 'react-redux';
import { addTraining } from './trainingSlice';

const TrainingForm = () => {
    const dispatch = useDispatch();

    const titleRef = useRef();
    const [trainingType, setTrainingType] = useState(true)
    const priceRef = useRef();
    const descriptionRef = useRef();
    const imageRef = useRef();

    const getBase64 = file => {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.onloadend = () => resolve(reader.result);
            reader.onerror = reject;
            reader.readAsDataURL(file);
        })
    }
    
    const trainingSubmit = async (e) => {
        e.preventDefault();           

        const training = {
            title: titleRef.current.value,
            description: descriptionRef.current.value,
            price: priceRef.current.value,
            inter: trainingType,
            subThemes: []
        }
        if (imageRef.current.files[0]) {
            const base64image = await getBase64(imageRef.current.files[0]);
            training.imagePath = base64image;
        }
        console.log(training);
        dispatch(addTraining(training));
    };

    const handleTypeChange = (e) => {
        setTrainingType(e.target.value === "inter")
    }

    return (
        <main>
            <div>
              <h2> Ajouter une Formation </h2>
              <hr />
            </div>
            <form onSubmit={trainingSubmit}>
                <div>
                    <label htmlFor="title">Titre: </label>
                    <input type="text" id='title' required ref={titleRef} />
                </div>

                <fieldset>
                    <legend>Type de formation</legend>
                    <div>
                        <input type="radio" name="type" id="inter" value="inter" 
                        onChange={handleTypeChange} checked={trainingType === true}/>
                        <label htmlFor="inter">inter-entreprise</label>
                    </div>
                    <div>
                        <input type="radio" name="type" id="intra" value="intra" 
                        onChange={handleTypeChange} checked={trainingType === false}/>
                        <label htmlFor="intra">intra-entreprise</label>
                    </div>
                </fieldset>

                <div>
                    <label htmlFor="price">prix: </label>
                    <input type="number" id="price" min={0} step={0.01} ref={priceRef} required />
                </div>
                
                <div>
                    <label htmlFor="description">Descriptif de la formation: </label>
                    <textarea id="description" rows={10} cols={35} ref={descriptionRef} defaultValue={"# Vous pouvez écrire avec la syntaxe markdown."}>
                    </textarea>
                </div>

                <div>
                    <label htmlFor="image">Ajouter une image:</label>
                    <input type="file" id="image" accept='.jpg, .jpeg, .png' ref={imageRef}/>
                </div>


                <Button type={"submit"} children={"Valider"}/>

            </form>
        </main>
    );
}

export default TrainingForm;
