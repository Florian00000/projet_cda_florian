import React, { useEffect } from 'react';
import { useSearchParams } from 'react-router-dom';
import {useDispatch, useSelector} from 'react-redux'
import { fetchAllTheme } from './themeSlice';
import ThemeList from './ThemeList';

const HomeTheme = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const dispatch = useDispatch();

    const mode = searchParams.get("mode") ?? "theme"; 
    const list = useSelector((state) => state.theme.list);

    useEffect(() => {
        switch (mode) {
                case "theme":
                    dispatch(fetchAllTheme());                    
                    break;
            
                default:
                    break;
            }
    }, [])

    

    return (
        <main>
            <div>
                <h2>Formations proposées</h2>
                <hr />
            </div>
            

            <ThemeList list={list}/>
        </main>
    );
}

export default HomeTheme;
