import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchSessionsByUser } from './trainingSlice';
import SessionRectangle from './SessionRectangle';

const MySessions = () => {
    const {sessions} = useSelector((state) => state.training)
    const { user, token } = useSelector((state) => state.authentication)
    const dispatch = useDispatch();


    useEffect(() => {
        const credentials = {
            user: user,
            token:token
        }
        dispatch(fetchSessionsByUser(credentials))
    },[dispatch, user, token]);

    if (!sessions.length) {
        return (
            <main>
                <p>Vous n'êtes inscrits à aucune session.</p>
            </main>
        )
    }

    return (
        <main>
            <div>
                <h2>Mes Sessions</h2>
                <hr />
            </div>

            { sessions && sessions.length && 
                <section>
                    {sessions.map((session, index) =>(
                        <SessionRectangle session={session} key={index}/>
                    ))}

                </section>
            }          
            
        </main>
    );
}

export default MySessions;
