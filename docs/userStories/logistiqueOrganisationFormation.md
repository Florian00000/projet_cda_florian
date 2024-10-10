# Logistique pour l'organisation de la formation

En tant que responsable logistique d'IT-Training, je souhaite gérer efficacement l'organisation des formations pour garantir le bon déroulement des sessions tout en respectant les délais et critères de participation.

## User Stories:
1. Planification des sessions inter-entreprises :
    - User Story:  
    *En tant que responsable logistique, je veux pouvoir planifier les sessions inter-entreprises sur toute l'année afin de proposer un calendrier fixe pour les clients.*
    - Critères d'acceptation:
        - Un calandrier fixe est généré poru chaque formation, avec des sessions récurrentes.
        - Le calendrier est consultable en ligne pour les clients, avec la possibilié de s'inscire directement.
2. Vérification du nombre minimum de participants :
    - User Story:  
    *En tant que responsable logistique, je veux être alerté 15 jours avant une session si le nombre minimum de participants n'est pas atteint afin de déclencher la procédure d'annulation.*
    - Critères d'acceptation:
        - Une alerte automatique est envoyée si le nombre minimum de participants n'est pas atteint 15 jours avant la session.
        - Le responsable logistique peut alors déclancher la procédure d'annulation: prévenir les apprenant et le formateur, annuler la réservation de la salle, etc.
3. Assignation et validation des formateurs:
    - User Story:  
    *En tant que responsable logistique, je veux pouvoir assigner un formateur à une session au moins trois mois à l'avance, en tenant compte de son expérience et des évaluations des stagiaires.*
    - Critères d'acceptation:
        - Le formateur est avertit automatiquement par mail, à une session en fonction de son expérience, de ses évaluations passées, et de ses disponibilitées.
        - Si c'est la première session du formateur, une séance de validation technique et pédagogique est prévue au moins trois semaines avant la formation.
        - Le formateur doit alors confirmer sa présence.
        - Le formateur peut annuler sa présence, mais si il le fait à moins de 15 jours de la formation, il reçoit un blâme.
4. Mise en place de la logistique de formation :
    - User Story:   
    *En tant que responsable logistique, je veux pouvoir déclencher automatiquement l'organisation logistique dès que le nombre minimum de participants est atteint afin d'informer toutes les parties concernées.*
    - Critères d'acceptation:
        - Dès que le nombre minimum de participants est atteint, la salle est automatiquement réservée.
        - Les convocations sont envoyées par courrier et email aux stagiaires et le formateur est prévenu.
        - Les formulaires HTML d’évaluation de la session sont générés automatiquement et assignés de manière nominative aux stagiaires.
5. Génération des formulaires d'évaluations:
    - User Story:  
    *En tant que responsable logistique, je veux pouvoir générer automatiquement des formulaires d’évaluation en ligne pour les stagiaires afin de recueillir leur reout sur la formation et sur le formateur.*
    - Critères d'acceptation:
        - Les formulaires d’évaluation en ligne sont créés de manière nominative pour chaque stagiaire.
        - Les résultats sont centralisés et utilisés pour évaluer la performance des formateurs pour les sessions futures.
6. Mofification et Suppression des formations:
    - User Story:  
    *En tant que responsable logistique, je veux pouvoir modifier ou supprimé les formations qui ne sont pas encore lancé*
    - Critères d'acceptation:
        - Le responsable logistique peut modifier les détails d'une formation ou la supprimer, tant que la session n'a pas débuté.
        - Le calendrier en ligne est mis à jour en temps réel pour refléter les modifications.