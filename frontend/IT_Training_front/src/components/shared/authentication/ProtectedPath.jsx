import React from 'react';
import { useSelector } from 'react-redux';
import { Navigate } from 'react-router-dom';

const ProtectedPath = (props) => {
    const { user } = useSelector((state) => state.authentication);

    if (user) {
        return (
            <>
                {props.children}
            </>
        );
    } else {
        return <Navigate to={"/authentication"} />
    }

}

export default ProtectedPath;
