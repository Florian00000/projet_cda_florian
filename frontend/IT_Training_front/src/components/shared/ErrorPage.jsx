import React from 'react';
import {Link, useRouteError } from 'react-router-dom'

const ErrorPage = () => {
    const error = useRouteError()

    return (
        <>
            <h1>Error: {error.status}  </h1>
            <p> {error.data} </p>
            <Link to={'/'}>Revenir à l'accueil</Link>
        </>
    );
}

export default ErrorPage;