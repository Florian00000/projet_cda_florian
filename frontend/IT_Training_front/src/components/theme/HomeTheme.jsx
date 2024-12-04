import React, { useEffect, useState } from 'react';
import { useParams, useSearchParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux'
import { fetchAllTheme, fetchAllSubThemeByThemeId, fetchAllTrainingBySubThemeId, fetchAllTrainings, searchTraining } from './themeSlice';
import ThemeList from './ThemeList';
import classes from './Theme.module.css'

const HomeTheme = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const dispatch = useDispatch();
    const { idList } = useParams();


    const mode = searchParams.get("mode") ?? "theme";

    const [searchTerm, setSearchTerm] = useState("");

    const handleSearch = (e) => {
        const value = e.target.value;
        setSearchTerm(value);
        dispatch(searchTraining(value))
        if (value) {
            if (value.length === 1) {
                dispatch(fetchAllTrainings());
            }
        } else {
            dispatchList()
        }
    }

    const dispatchList = () => {
        switch (mode) {
            case "theme":
                dispatch(fetchAllTheme());
                break;
            case "subtheme":
                if (idList) {
                    dispatch(fetchAllSubThemeByThemeId(idList))
                }
                break;
            case "training":
                if (idList) {
                    dispatch(fetchAllTrainingBySubThemeId(idList))
                }
                break;
        }
    }


    useEffect(() => {
        dispatchList();
    }, [mode, idList, dispatch])

    return (

        <main>
            <div>
                <div className={classes.divTitle}>
                    {(mode === "theme" && searchTerm.length === 0) && (<h2>Domaines proposées</h2>)}
                    {(mode === "subtheme" && searchTerm.length === 0) && (<h2>Spécialitées techniques proposées</h2>)}
                    {(mode === "training" || searchTerm.length > 0) && (<h2>Formations proposées</h2>)}
                    <input type="text" placeholder='Rechercher une formation' onChange={handleSearch} value={searchTerm} />
                </div>

                <hr />
            </div>


            <ThemeList />
        </main>
    );



}

export default HomeTheme;
