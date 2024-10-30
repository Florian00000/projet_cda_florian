import React, { useEffect } from 'react';
import { useParams, useSearchParams } from 'react-router-dom';
import {useDispatch, useSelector} from 'react-redux'
import { fetchAllTheme, fetchAllSubThemeByThemeId } from './themeSlice';
import ThemeList from './ThemeList';

const HomeTheme = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const dispatch = useDispatch();
    const { idSubTheme } = useParams();

    const mode = searchParams.get("mode") ?? "theme"; 

    useEffect(() => {
        switch (mode) {
                case "theme":
                    dispatch(fetchAllTheme());                    
                    break;
                case "subtheme":          
                    if (idSubTheme) {
                        dispatch(fetchAllSubThemeByThemeId(idSubTheme))
                    }              
                    break;            
                default:
                    break;
            }
    }, [mode, idSubTheme, dispatch])

    

    return (
        <main>
            <div>
                <h2>Formations proposées</h2>
                <hr />
            </div>
            

            <ThemeList />
        </main>
    );
}

export default HomeTheme;
