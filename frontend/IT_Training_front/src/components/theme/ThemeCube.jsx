import React from 'react';
import classes from './Theme.module.css'
import { BASE_URL_IMAGE } from '../../utils/constant';

const ThemeCube = ({theme, onClick}) => {
    return (
        <div className={classes.card} onClick={onClick}>
            <img src={BASE_URL_IMAGE+theme.imagePath} alt={`logo ${theme.title}`}/>               
            <h3>{theme.title} </h3>
        </div>
    );
}

export default ThemeCube;
