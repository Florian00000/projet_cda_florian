import React, { useEffect } from 'react';

const SessionModal = ({session}) => {

    useEffect(()=> {
        console.log(session);
        console.log(getPlanningOfWeek(session.courses));
        
    }, [])

    const parseDate = (dateString) => {
        const [day, month, year] = dateString.split('/');
        return new Date(`${year}-${month}-${day}`)
    }
    
    const getPlanningOfWeek = (courses) => {
        const planning = new Set();
        return courses.filter(course => {
            const dayName = new Intl.DateTimeFormat('fr-FR', {weekday: 'long'}).format(parseDate(course.date))

            if (!planning.has(dayName)) {
                planning.add(dayName)
                return true;
            }
            return false
        });
    } 

    return (
        <div>
            <h3>du {session.startDate} au {session.endDate}</h3>
            <hr />

            <article>
                {getPlanningOfWeek(session.courses).map((day, index) => (
                    <p key={index}> {new Intl.DateTimeFormat('fr-FR', {weekday: 'long'}).format(parseDate(day.date))}: 
                        <span> {day.startHour.slice(0,5)} - {day.endHour.slice(0,5)} </span> 
                     </p>
                ))}
            </article>
            
        </div>
    );
}

export default SessionModal;
