import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchSessionsByTrainingId, fetchTrainingById } from "./trainingSlice";
import { useParams, Link, useNavigate } from "react-router-dom";
import Markdown from "react-markdown";
import remarkGfm from "remark-gfm";
import classes from "./Training.module.css";
import Button from "../shared/Button";
import SessionCube from "./SessionCube"
import { fetchUserHasNote } from "../testUser/testUserSlice";

const TrainingDetail = () => {
  const dispatch = useDispatch();
  const { idTraining } = useParams();
  const training = useSelector((state) => state.training.training);
  const sessions = useSelector((state) => state.training.sessions);
  const { token, user } = useSelector((state) => state.authentication)
  const { userHasPassedTest } = useSelector((state) => state.testUser)
  const navigate = useNavigate();

  useEffect(() => {
    dispatch(fetchTrainingById(idTraining));
    dispatch(fetchSessionsByTrainingId(idTraining))
  }, [idTraining, dispatch]);

  useEffect(() => {
    if (training?.testUser && token) {
      const credentials = {
        idTestUser: training.testUser.id,
        idUser: user.userId,
        token: token
      }
      dispatch(fetchUserHasNote(credentials))
    }
  }, [training, token, user, dispatch])

  const redirectTo = () => {
    navigate(`/training/testUser/${training.testUser.id}`)
  }

  const renderTestButton = () => {   
    if (!token) {
      return (
        <div>
          <Button children={"Tester ses compétences"} disabled={true} />
          <p className={classes.blueTextNotConnected}>Connectez-vous pour passer le test</p>
        </div>
      );
    }
  
    if (training.testUser) {
      if (userHasPassedTest?.completed) {
        return (
          <div>
            <Button children={"Tester ses compétences"} onClick={redirectTo} disabled={true} />
            <p className={classes.blueTextNotConnected}>
              Résultat du test : {userHasPassedTest?.success ? "Réussi" : "Échec"}
            </p>
          </div>
        );
      }
  
      return <Button children={"Tester ses compétences"} onClick={redirectTo} />;
    }  
    
    return <Button children={"Tester ses compétences"} disabled={true} />;
  }

  return (
    <main>
      {training ? (
        <>
          <article>
            <div>
              <h2> {training.title} </h2>
              <hr />
            </div>

            <div className={classes.listSubThemes}>
              {training.subThemes && training.subThemes.map((subTheme, index) => (
                <span key={index}>{subTheme.title}</span>
              ))}
            </div>

            <section className={classes.sectionTraining}>
              <div>
                <Markdown remarkPlugins={[remarkGfm]}>
                  {training.description}
                </Markdown>
              </div>
              {training.price && training.price != 0 ? (<p>prix: {training.price} €</p>) : ((<p>prix: gratuit</p>))}

              <div className={classes.spaceAround}>
                <Link to={"#"}>Entreprise? je personnalise ma formation</Link>

                {renderTestButton()}

              </div>
            </section>

            {sessions.length != 0 && (<section className={classes.sectionSessions}>
              {sessions.map((session, index) => (
                <SessionCube key={index} session={session} />
              ))}
            </section>)}

          </article>
        </>
      ) : (
        <p>Chargement des détails de la formation...</p>
      )}
    </main>
  );
};

export default TrainingDetail;
