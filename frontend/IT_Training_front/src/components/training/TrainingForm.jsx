import React, { useEffect, useRef, useState } from 'react';
import Button from '../shared/Button';
import { useDispatch, useSelector } from 'react-redux';
import { addTraining, changeStatusAddTraining } from './trainingSlice';
import { fetchAllSubThemes } from '../theme/themeSlice';
import { getBase64 } from '../../utils/methods';
import Modal from '../shared/modal/Modal';
import { useNavigate } from 'react-router-dom';

const TrainingForm = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const subThemes = useSelector((state) => state.theme.list)
    const returnStatus = useSelector((state) => state.training.statusAddTraining)
    const training = useSelector((state) => state.training.training)
    const [isModalOpen, setModalOpen] = useState(false);

    const titleRef = useRef();
    const [trainingType, setTrainingType] = useState(true)
    const priceRef = useRef();
    const descriptionRef = useRef();
    const imageRef = useRef();
    const [selectedSubThemes, setSelectedSubThemes] = useState([]);
    
    const trainingSubmit = async (e) => {
        e.preventDefault();           

        const training = {
            title: titleRef.current.value,
            description: descriptionRef.current.value,
            price: priceRef.current.value,
            inter: trainingType,
            subThemes: selectedSubThemes
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

    const handleSubThemeChange = (e) => {
        const value = +e.target.value;
        setSelectedSubThemes((prev) => 
        e.target.checked ? [...prev, value] : prev.filter((id) => id !== value))
    }

    const closeModal = () => {
        dispatch(changeStatusAddTraining(null))        
        setModalOpen(false);
        navigate(`/training/${training.id}`)
    }

    useEffect(() => {
        dispatch(fetchAllSubThemes())        
    }, [dispatch])

    useEffect(() => {
        if (returnStatus) {           
            
            setModalOpen(true)
        }
    }, [returnStatus])


    return (
        <main>
            
            {isModalOpen && (
                console.log("modal"),
                <Modal changeModal={closeModal} buttonChildren={"ok"}>
                    <p>Formation ajouté avec succès</p>
                </Modal>
            )}

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

                <fieldset>
                    <legend>Ajouter des thèmes</legend>
                    {subThemes.map((subTheme, index) => (
                        <div key={index}>
                            <input type="checkbox" id={subTheme.id} value={subTheme.id} onChange={handleSubThemeChange}/>
                            <label htmlFor={subTheme.id}>{subTheme.title} </label>
                        </div>
                    ))}
                </fieldset>


                <Button type={"submit"} children={"Valider"}/>

            </form>
        </main>
    );
}

export default TrainingForm;
