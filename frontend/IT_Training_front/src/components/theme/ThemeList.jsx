import React from 'react';
import ThemeCube from './ThemeCube';
import classes from './Theme.module.css'

const ThemeList = ({list}) => {
    return (
        <section className={classes.list}>
            {list.map((theme, index) => (
                <ThemeCube key={index} theme={theme}/>                
            ))} 
        </section>
    );
}

export default ThemeList;
