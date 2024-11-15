import React from 'react';
import {createPortal} from 'react-dom'
import classes from "./Modal.module.css"
import Button from '../Button';

const Modal = (props) => {   
    let {changeModal, buttonChildren} = props

    return createPortal (
        <div className={classes.modal} >
            <div className={classes.modalContent} > 
            {props.children} 

            <Button onClick={changeModal} children={buttonChildren} ></Button>
            </div>
        </div>,
        document.body
    );
}

export default Modal;
