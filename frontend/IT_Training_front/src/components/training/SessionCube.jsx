import React, { useEffect, useState } from 'react';
import classes from "./Training.module.css";

const SessionCube = ({ session }) => {
    const [earliestHour, setEarliestHour] = useState();
    const [latestHour, setLatestHour] = useState();

    useEffect(() => {
        if (session.courses?.length) {
            const startHour = session.courses.map((course) => {
                return course.startHour.slice(0,5)
            })
            const endHour = session.courses.map((course) => {
                return course.endHour.slice(0,5)
            })
            setEarliestHour(startHour.reduce((min, current) => {
                return current < min ? current : min;
            }, startHour[0]))
            setLatestHour(endHour.reduce((max, current) => {
                return current > max ? current : max;
            }, endHour[0]))                      
        }
        
        
    }, [session])

    return (
        <article className={classes.articleSession}>
            <p>du {session.startDate} au {session.endDate}</p>
            <hr />
            { earliestHour && latestHour ? (<p>Plage horaire: {earliestHour} - {latestHour} </p>) :(<p>informations sur les horaires à venir</p>) }
            <p>{session.location.city}</p>
        </article>
    );
}

export default SessionCube;
