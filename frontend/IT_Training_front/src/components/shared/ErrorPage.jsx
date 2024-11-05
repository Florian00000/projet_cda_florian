import React from 'react';
import {Link, useRouteError } from 'react-router-dom'

const ErrorPage = () => {
    const error = useRouteError()

    return (
        <>
            <h1>Error: {error?.status || "Erreur inconnue"}  </h1>
            <p> {error?.statusText || error?.data || error?.message || "Une erreur inattendue s'est produite."} </p>
            <Link to={'/'}>Revenir à l'accueil</Link>
        </>
    );
}

export default ErrorPage;