import React, { useEffect } from 'react';
import { useParams, useSearchParams } from 'react-router-dom';
import {useDispatch, useSelector} from 'react-redux'
import { fetchAllTheme, fetchAllSubThemeByThemeId } from './themeSlice';
import ThemeList from './ThemeList';
import Markdown from 'react-markdown'
import remarkGfm from 'remark-gfm'

const HomeTheme = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const dispatch = useDispatch();
    const { idSubTheme } = useParams();

    const mode = searchParams.get("mode") ?? "theme"; 

//     const testMarkdown = `A paragraph with *emphasis* and **strong importance**.

// > A block quote with ~strikethrough~ and a URL: https://reactjs.org.

// * Lists
// * [ ] todo
// * [x] done

// ## test

// - test

// A table:

// | a | b |
// | - | - |
// `

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

            {/* <Markdown remarkPlugins={[remarkGfm]}>{testMarkdown}</Markdown> */}
            

            <ThemeList />
        </main>
    );
}

export default HomeTheme;
