# Enregistrement en ligne pour suivre une session de formation
En tant qu'utilisateur intéressé par une formation, je souhaite m'inscrire en ligne à une session, choisir la date et le lieu, et avoir la possibilité de demander des sessions intra-entreprises ou des formations personnalisées, afin d'obtenir une expérience adaptée à mes besoins professionnels.

## User stories:
1. Inscription en ligne à une session de formation:
    - User Story:  
    *En tant que client, je veux pouvoir m'inscrire en ligne à une session de formation en choisissant la date et le lieu de la session pour réserver ma place.*
    - Critères d'acceptation:
        - L'utilisateur peut sélectionner une formation, puis choisir la date et le lieu parmi les sessions proposées.
        - Un lien permet de s'inscrire ou s'authentifier, avant de s'inscrire à la formation.
        - Un message de confirmation s'affiche après l'inscription, et un email est envoyé au client.

2. Test de prérequis:
    - User Story:  
    *En tant que client, je dois passer le test des prérequis avant de m'inscrire à une formation pour m'assurer que j'ai le niveau requis.*
    - Critères d'acceptation:
        - Le bouton pour s'inscire à la formation est verouillé tant que le test n'est pas passé.
        - Le lien pour passer les tests prérequis est mis en avant sur la page de la formation. 
        - Une fois le test passé, un lien permet de s'inscrire ou s'authentifier afin de garder ses résultats aux tests.

3. Demande de session intra-entreprise:
    - User Story:  
    *En tant que client, je veux pouvoir demander une session intra-entreprise qui se déroulera dans mes locaux ou dans une salle réservée par IT-Training, afin d'avoir une formation adaptée à mon entreprise.*
    - Critères d'acceptation: 
        - Un bouton "Demander une session intra-entreprise" est disponible sur la page d'inscription.
        - Le client peut choisir entre une session dans son entreprise ou dans une salle réservée.
        - Un formulaire permet de renseigner les dates souhaitées.
        - Le client peut s'inscrire/s'authentifier et préciser qu'il est une entreprise.

4. Demande de formation personnalisée:
    - User Story:
    *En tant que client, je veux pouvoir demander une formation personnalisée avec un plan adapté à mes besoins pour avoir un programme sur mesure.*
    - Critères d'acceptation: 
        - Un lien pour une formation personnalisée est disponible, il renvoie au mail du responsable d'enregistrement des formations.
        - Un plan de formation est généré et envoyé au client pour validation avant la mise en place de la formation.