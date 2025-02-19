# IT Training - Plateforme de gestion de formations

## Description

IT Training est une application web permettant de gérer des formations, incluant la gestion des utilisateurs, des sessions et des lieux de formation.
L'application est développée en Spring Boot (Backend) et React avec Vite (Frontend), avec une architecture bien structurée pour faciliter la maintenance et l'évolutivité.

---
## Architecture de l'application

### Backend (Spring Boot)
L'architecture backend est organisée en plusieurs couches :

- Couche Entity (Modèle) : Représente les objets métiers liés à la base de données.
- Couche Repository (DAO) : Interaction directe avec la base de données via JPA/Hibernate.
- Couche Service : Contient la logique métier et la gestion des transactions.
- Couche Controller : Gère les requêtes HTTP et expose les endpoints REST.
- Couche DTO (Data Transfer Object) : Structure les données envoyées et reçues par le client.
- Couche Exception : Gestion centralisée des erreurs et exceptions.
- Couche Configuration : Paramétrage de la sécurité et des configurations initiales (JWT, Faker).

👉 Le backend expose une API REST qui communique avec le frontend.

---

### Frontend (React + Vite)

Le frontend est développé en React, et utilise Vite pour des performances optimisées. Il consomme les endpoints du backend via des appels **API REST**.

### Base de données
L'application utilise MySQL comme base de données relationnelle et MongoDb pour le NoSQL. 

--- 

## Technologies utilisées

### Spring Boot :

- Spring Security (Gestion des utilisateurs et authentification JWT)
- JPA / Hibernate (ORM pour l'accès aux données)
- PostgreSQL (Base de données)

### React.js :

- Vite (Build tool rapide pour React)
- Axios (Appels API REST)
- JWT-Decode
- React-Router
- React-Markdown
- React-Redux

### DevOps & CI/CD :

- GitHub Actions (CI/CD)
- Docker & Docker Compose (Conteneurisation)
- Docker Hub (Stockage des images Docker)

----

## Installation et exécution

### 🐳 Option 1: Exécution avec Docker

1. Créer un fichier `.env` à la racine en utilisant le fichier `exemple.env` comme exemple pour les noms des variables. 

2. Lancer les services
```bash
docker-compose up -d
```

3. Accéder à l'application

- Frontend: http://localhost:80
- Backend: http://localhost:8080/api/training

## Exécution en monde Développement 

1. Créer un fichier `.env` dans le dossier `backend\IT_Training_back` en utilisant le fichier `backend\IT_Training_back\exemple.env` comme exemple pour les noms des vratiables.

2. Démarrer les services MySQL et MongoDB.

3. Lancer le backend 
```bash
cd backend/IT_Training_back
./mvnw spring-boot:run

```

4. Lancer le frontend
```bash
cd frontend/IT_Training_front
npm install
npm run dev
```

5. Accéder à l'application

- Frontend: http://localhost:5173
- Backend: http://localhost:8080/api/training