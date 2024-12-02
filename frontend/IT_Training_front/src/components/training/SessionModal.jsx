import React, { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { Link, useNavigate } from 'react-router-dom';
import Button from '../shared/Button';
import classes from "./Training.module.css";

const SessionModal = ({ session }) => {
    const { token } = useSelector((state) => state.authentication)
    const { userHasPassedTest } = useSelector((state) => state.testUser)
    const { training } = useSelector((state) => state.training);

    const navigate = useNavigate();

    useEffect(() => {
        console.log(session);

        console.log(userHasPassedTest);


    }, [])

    const parseDate = (dateString) => {
        const [day, month, year] = dateString.split('/');
        return new Date(`${year}-${month}-${day}`)
    }

    const getPlanningOfWeek = (courses) => {
        const planning = new Set();
        return courses.filter(course => {
            const dayName = new Intl.DateTimeFormat('fr-FR', { weekday: 'long' }).format(parseDate(course.date))

            if (!planning.has(dayName)) {
                planning.add(dayName)
                return true;
            }
            return false
        });
    }

    const redirectToTest = () => {
        navigate(`/training/testUser/${training.testUser.id}`)
      }

    const renderButton = () => {
        if (training?.testUser) {
            if (userHasPassedTest?.completed) {
                if (userHasPassedTest?.success) {
                    return (
                        <div className={classes.divButtonsModal}>
                            <div>
                                <Button children={"Tester ses compétences"} disabled={true} size={"medium-white"} />
                                <p className={classes.blueTextNotConnected}>
                                    Résultat du test : Réussi
                                </p>
                            </div>
                            <Button children={"Je m'inscris à la session"} />
                        </div>
                    )
                }
                return (
                    <div className={classes.divButtonsModal}>
                        <div>
                            <Button children={"Tester ses compétences"} disabled={true} size={"medium-white"} />
                            <p className={classes.blueTextNotConnected}>
                                Résultat du test : Échec
                            </p>
                        </div>
                        <div>
                            <Button children={"Je m'inscris à la session"} disabled={true}/>
                            <p className={classes.blueTextNotConnected}>
                                Malheureusement vous n'avez pas réussi le test.
                            </p>
                        </div>
                    </div>
                );
            }
            return (
                <div className={classes.divButtonsModal}>
                    <Button children={"Tester ses compétences"} size={"medium-white"} onClick={redirectToTest} />
                    <div>
                        <Button children={"Je m'inscris à la session"} disabled={true} />
                        <p className={classes.blueTextNotConnected}>Passez le test avant de vous inscire</p>
                    </div>
                    
                </div>

            )
        }
        return <Button children={"Je m'inscris à la session"} />;
    }

    return (
        <div >
            <h3>du {session.startDate} au {session.endDate}</h3>
            <hr />

            <article >
                {getPlanningOfWeek(session.courses).map((day, index) => (
                    <p key={index} className={classes.textAlignLeft}> {new Intl.DateTimeFormat('fr-FR', { weekday: 'long' }).format(parseDate(day.date))}:
                        <span> {day.startHour.slice(0, 5)} - {day.endHour.slice(0, 5)} </span>
                    </p>
                ))}

                {token ?
                    renderButton()
                    : <Link to={"/authentication"} >Connectez-vous pour vous inscrire à la sessions </Link>}
            </article>

        </div>
    );
}

export default SessionModal;
