import React, { useEffect, useState } from 'react';
import classes from "./Training.module.css";
import SessionModal from './SessionModal';
import ModalButtonless from '../shared/modal/ModalButtonless';

const SessionCube = ({ session }) => {
    const [earliestHour, setEarliestHour] = useState();
    const [latestHour, setLatestHour] = useState();
    const [openModal, setOpenModal] = useState(false);

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
        <>
            {openModal && 
                <ModalButtonless changeModal={() => setOpenModal(false)} >
                    <SessionModal session={session}/>
                </ModalButtonless>}

            {session?.users.length < session?.placeLimit ? 
                <article className={[classes.articleSession, classes.pointer].join(' ')} onClick={() => setOpenModal(!openModal)}>
                    <p>du {session.startDate} au {session.endDate}</p>
                    <hr />
                    { earliestHour && latestHour ? (<p>Plage horaire: {earliestHour} - {latestHour} </p>) :(<p>informations sur les horaires à venir</p>) }
                    <p>{session.location.city}</p>
                </article>
                : 
                <article className={classes.articleSession}>
                    <p>du {session.startDate} au {session.endDate}</p>
                    <hr />
                    { earliestHour && latestHour ? (<p>Plage horaire: {earliestHour} - {latestHour} </p>) :(<p>informations sur les horaires à venir</p>) }
                    <p>plus de places disponibles</p>
                    <p>{session.location.city}</p>
                </article>
            }

            
        </>
        
    );
}

export default SessionCube;
