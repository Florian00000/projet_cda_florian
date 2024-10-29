import React from 'react';
import ThemeCube from './ThemeCube';
import classes from './Theme.module.css'
import { Link, useNavigate, useSearchParams } from 'react-router-dom';

const ThemeList = ({list}) => {
    const [searchParams, setSearchParams] = useSearchParams();
    const navigate = useNavigate();
    const mode = searchParams.get("mode") ?? "theme";

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
