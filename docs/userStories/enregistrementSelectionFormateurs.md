# Enregistrement et sélection des formateurs.

En tant que responsable de formation, je veux permettre aux formateurs potentiels de soumettre leur candidature en ligne et de gérer leur espace personnel.

## User Stories:

1. Candidature du formateur:
    - User Story:  
    *En tant que formateur potentiel, je veux pouvoir remplir un formulaire de candidature en ligne avec mes informations personnelles et professionnelles afin de postuler pour devenir formateur chez IT-Training.*
    - Critères d'acceptation:
        - Le formulaire de candidature doit inclure les champs suivants : nom, prénom,  email, téléphone, choix technologique et expérience.
        - Le formulaire doit être validé pour s'assurer que tous les champs obligatoires sont remplis.
        - Une notification doit être envoyée au responsable de formation une fois qu'une nouvelle candidature est soumise.

2. Validation de la candidature par le responsable de la formation:
    - User Story:  
    *En tant que responsable de formation, je veux pouvoir consulter les candidatures des formateurs et valider ou rejeter chaque candidature afin de sélectionner les formateurs appropriés pour nos formations.*
    - Critères d'acceptation:
        - Le responsable de formation doit avoir accès à une liste des candidatures avec les informations soumises.
        - Il doit pouvoir valider ou rejeter une candidature avec une option pour ajouter des commentaires.
        - Une fois la décision prise, un email doit être automatiquement envoyé au formateur pour l’informer de la validation ou du refus de sa candidature.

3. Création de l'espace personnel du formateur:
    - User Story:  
    *En tant que formateur validé, je veux pouvoir créer un compte personnel avec un nom d'utilisateur et un mot de passe afin d'accéder à mon espace en ligne.*
    - Critères d'acceptation:  
        - Un email contenant un lien vers la page d'enregistrement doit être envoyé au formateur après la validation de sa candidature.
        - La page d'enregistrement doit demander le nom, l'email et le mot de passe du formateur.
        - Un système de vérification doit être en place pour s'assurer que l'email n'est pas déjà utilisé.
        - Après l'enregistrement, le formateur doit être redirigé vers son espace personnel.

4. Gestion de l'espace personnel du formateur: 
    - User Story:  
    *En tant que formateur, je veux pouvoir accéder à mon espace personnel en ligne où je peux voir mes formations passées, formations proposées, et formations acceptées afin de gérer mon emploi du temps.*
    - Critères d'acceptation:  
        - L'espace personnel doit afficher une liste des formations passées avec les détails (nom, date et notes).
        - Les formations proposées doivent être affichées avec une option pour accepter ou refuser chaque formation.
        - Les formations acceptées doivent être listées avec les détails pertinents (date, lieu, etc.).

5. Notification de refus de candidature:
    - User story:
    *En tant que formateur dont la cnadidature a été refusée, je veux recevoir in email générique m'informant que ma candidature n'a pas été retenue afin de savoir que je peux réessayer le mois suivant*