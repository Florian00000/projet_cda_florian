import React from 'react';
import classes from "./Training.module.css";

const SessionCube = ({session}) => {
    return (
        <article className={classes.articleSession}>
            <p>du {session.startDate} au {session.endDate}</p>
            <hr />
            <p>informations sur les horaires à venir</p>
            <p>{session.location.city}</p>
        </article>
    );
}

export default SessionCube;
