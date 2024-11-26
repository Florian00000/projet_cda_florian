import React from 'react';
import { useSelector } from 'react-redux';
import { Navigate } from 'react-router-dom';


const ProtectedPathAdmin = (props) => {
    const { user } = useSelector((state) => state.authentication);

    if (user && user.roles.split(",").includes("ROLE_ADMIN")) {
         return (
        <>
            {props.children}
        </>
    );
    }else{
        return <Navigate to={"/authentication"}/>
    }

   
}

export default ProtectedPathAdmin;
