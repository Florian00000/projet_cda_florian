import React from 'react';
import classes from './Theme.module.css'

const ThemeCube = ({theme}) => {
    return (
        <div className={classes.card}>
            <img src={theme.imagePath} alt={`logo ${theme.title}`}/>
            <h3>{theme.title} </h3>
        </div>
    );
}

export default ThemeCube;
