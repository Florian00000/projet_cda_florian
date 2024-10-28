import React from 'react';
import classes from './Theme.module.css'

const ThemeCube = ({theme}) => {
    return (
        <div className={classes.card}>
            <h3>{theme.title} </h3>
        </div>
    );
}

export default ThemeCube;
