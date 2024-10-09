# Evaluation de la session

En tant que responsable des formations, je souhaite collecter les évaluations des stagiaires à la fin de chaque session afin d'assurer un suivi qualité, d'identifier rapidement les problèmes, et d'améliorer les services de formation.

## User Stories:

1. Saisie des évaluations par les stagiaires:
    - User Story:  
    *En tant que stagiaire, je veux pouvoir évaluer la session de formation que j'ai suivie en notant l'accueil, l'environnement et le contenu de la formation pour partager mon niveau de satisfaction.*
    - Critères d'acceptation:  
        - Chaque stagiaire reçoit un formulaire d’évaluation en ligne le dernier jour de la formation.
        - L’évaluation comporte des sections pour évaluer l’accueil, l’environnement (salles, machines, repas) et le contenu de la formation (jour par jour).
        - Une évaluation unique est possible par stagiaire et par session.
        - Les notes sont sur une échelle de 1 à 5 (1 étant médiocre, 5 étant excellent).
        - L’évaluation doit être complétée avant 14h30 le dernier jour de la session.
        - Le stagiaire doit aussi indiquer s'il recommande ou non cette formation et s’il envisage de suivre d’autres formations.
2. Evaluation du formateur par les stagiaires: 
    - User Story:   
    *En tant que stagiaire, je veux pouvoir évaluer le formateur sur différents aspects (pédagogie, maîtrise du domaine, disponibilité, etc.) afin d'exprimer mon opinion sur la qualité de l'enseignement.*
    - Critères d'acceptation: 
        - Le formateur est évalué sur cinq critères : pédagogie, maîtrise du domaine, disponibilité, réponses aux questions, techniques d'animation.
        - Les notes sont sur une échelle de 1 à 5 pour chaque critère.
3. Détection des insatisfactions et déclanchement d'alerte:
    - User Story:  
    *En tant que responsable de la formation, je veux être alerté immédiatement si un stagiaire donne une note inférieure à 3 sur un aspect clé de la formation (contenu, formateur, environnement) afin de pouvoir réagir rapidement.*
    - Critères d'acceptation:
        - Une alerte est générée sur le tableau de bord du responsable formation si une note inférieure à 3 est attribuée par un stagiaire pour un critère.
        - Le responsable de la formation reçoit une notification automatique si plusieurs stagiaires donnent une mauvaise note unanime sur un critère. Il est également spécifié si le stagiaire est sur la liste des personnes n'ayant pas le niveau, faite par le formateur.
        - Si un formateur reçoit systématiquement des notes inférieures à 3, il est automatiquement exclu de la base des formateurs si ces stagaires ne font pas partis de la liste qu'il a fournit.
4. Analyse des projets futurs des stagiaires:
    - User Story:  
    *En tant que responsable commercial, je veux accéder aux retours des stagiaires concernant leurs futurs projets de formation pour pouvoir leur proposer d'autres services IT-Training.*
    - Critères d'acceptation:
        - La liste des reour des stagiaires doit être disponibl.
        - Le système permer de contacter mes stagiaires intéressés par d'autres formations.