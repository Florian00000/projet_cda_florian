import React from 'react';
import {createPortal} from 'react-dom'
import classes from "./Modal.module.css"

const ModalButtonless = (props) => {
    let {changeModal} = props

    return createPortal (
        <div className={classes.modal} >
            <div className={classes.modalContentButtonless} > 
                <div className={classes.divCloseButton}>
                    <button onClick={changeModal} className={classes.closeButton}>X</button>
                </div>
            
            {props.children} 
            </div>
        </div>,
        document.body
    );
}

export default ModalButtonless;
