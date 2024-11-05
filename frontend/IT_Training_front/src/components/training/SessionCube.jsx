import React from 'react';

const SessionCube = ({session}) => {
    return (
        <div>
            <p>du {session.startDate} au {session.endDate}</p>
            <p>informations sur les horaires à venir</p>
        </div>
    );
}

export default SessionCube;
