import React, { useEffect, useState } from 'react';
import { getPlanningOfWeek, parseDate } from '../../utils/methodsDate';
import Button from '../shared/Button';
import classes from "./Training.module.css";
import { useSelector } from 'react-redux';
import { BASE_URL } from '../../utils/constant';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const SessionRectangle = ({ session }) => { 
    const { user, token } = useSelector((state) => state.authentication) 
    const [ isRated, setRated] = useState(null);  
    const navigate = useNavigate();

    const handleEvaluateButton = (idSession) => {
        navigate(`/evaluation/form/${idSession}`)
    }

    useEffect(() => {
        const fetchSessionHasRatedByUser = async () => {
            try {
                const response = await axios.get(`${BASE_URL}user/evaluation/${user.userId}/alreadyRated/${session.id}`,
                    {headers: {
                        "Authorization": `Bearer ${token}`
                    }}
                )
                return response.data;
            } catch (error) {
                const serializedError = error.response?.data || { message: error.message };
                return serializedError;
            }
        }

        const fetchData = async () => {
            const result = await fetchSessionHasRatedByUser();
            setRated(result.data)
        }
        fetchData();        
    },[user.userId, session.id, token])

    if (isRated === null) {
        return <p>Chargment...</p>
    }

    return (
        <article className={classes.articleSessionRectangle}>
            <div className={classes.spaceBetween}>
                <p>{session.training.title}</p> 
                <p>du {session.startDate} au {session.endDate}</p>
            </div>
            <hr />
            <div className={classes.spaceBetween}>
                <div>
                    {getPlanningOfWeek(session.courses).map((day, index) => (
                        <p key={index} > {new Intl.DateTimeFormat('fr-FR', { weekday: 'long' }).format(parseDate(day.date))}:
                            <span> {day.startHour.slice(0, 5)} - {day.endHour.slice(0, 5)} </span>
                        </p>
                    ))}
                </div>

                <div className={classes.blueText}>
                    <p><span>{session?.location.number}</span> <span>{session?.location.street}</span></p>
                    <p><span>{session?.location.zipCode}</span> <span>{session?.location.city}</span></p>
                </div>
                
                
            </div>
            <div className={classes.flexEnd}>
                <Button children={"Evaluer la session"} size={"medium"} disabled={isRated || (Date.now() < parseDate(session.startDate)) } onClick={() =>handleEvaluateButton(session?.id)} />
                {(Date.now() < parseDate(session.startDate)) && <p className={classes.blueTextNotConnected}>Vous ne pouvez pas encore évaluer cette session</p>}
                {isRated && <p className={classes.blueTextNotConnected}>Vous avez déjà évalué cette session</p>}
            </div>

        </article>
    );
}

export default SessionRectangle;
