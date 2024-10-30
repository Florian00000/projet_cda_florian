import React from 'react';
import ThemeCube from './ThemeCube';
import classes from './Theme.module.css'
import { useNavigate, useSearchParams } from 'react-router-dom';
import { useSelector } from 'react-redux';

const ThemeList = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const navigate = useNavigate();
    const mode = searchParams.get("mode") ?? "theme";
    const list = useSelector((state) => state.theme.list);

    const linkTo = (id) =>{  
        switch (mode) {
            case "theme":
                navigate(`/${id}?mode=subtheme`)   
                break;
            case "subtheme":
                //TODO
                console.log("faire la fonction");                
                break;
            default:
                break;
        }      
                   
    }

    return (
        <section className={classes.list}>
            {list.map((theme, index) => (            
                    <ThemeCube key={index} theme={theme} onClick={() => linkTo(theme.id)}/>                 
                                              
            ))} 
        </section>
    );
}

export default ThemeList;
