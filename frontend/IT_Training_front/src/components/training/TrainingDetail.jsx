import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchSessionsByTrainingId, fetchTrainingById } from "./trainingSlice";
import { useParams, Link } from "react-router-dom";
import Markdown from "react-markdown";
import remarkGfm from "remark-gfm";
import classes from "./Training.module.css";
import Button from "../shared/Button";
import SessionCube from "./SessionCube"

const TrainingDetail = () => {
  const dispatch = useDispatch();
  const { idTraining } = useParams();
  const training = useSelector((state) => state.training.training);
  const sessions = useSelector((state) => state.training.sessions);

  useEffect(() => {
    dispatch(fetchTrainingById(idTraining));
    dispatch(fetchSessionsByTrainingId(idTraining))
  }, [idTraining, dispatch]);

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
              {training.subThemes.map((subTheme, index) => (
                <span key={index}>{subTheme.title}</span>
              ))}
            </div>

            <section className={classes.sectionTraining}>
              <div>
                <Markdown remarkPlugins={[remarkGfm]}>
                  {training.description}
                </Markdown>
              </div>
              {training.price && <p>prix: {training.price} €</p>}
              <div className={classes.spaceAround}>
                <Link to={"#"}>Entreprise? je personnalise ma formation</Link>
                <Button children={"Tester ses compétences"}></Button>
              </div>
            </section>

            { sessions.length && (<section className={classes.sectionSessions}>
                {sessions.map((session, index) => (
                    <SessionCube key={index} session={session}/>
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
