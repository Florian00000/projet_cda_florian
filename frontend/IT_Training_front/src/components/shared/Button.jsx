import React from 'react';
import PropTypes from 'prop-types'

const Button = ({
    children,
    disabled = false,
    type = 'button',
    onClick,
    size = 'medium',
    style
}) => {

    let buttonClass = '';
    switch (size) {
        case 'small':
            buttonClass = 'button-small';
            break;
        case 'medium':
            buttonClass = 'button-medium';
            break;
        case 'large':
            buttonClass = 'button-large';
            break;    
        default:
            buttonClass = 'button-medium';
            break;
    }

    return (
    <button type={type} disabled={disabled} onClick={onClick} className={buttonClass} style={style}>
        {children}
    </button>
    );
}

Button.propTypes = {
    children: PropTypes.node.isRequired,
    onClick: PropTypes.func,
    disabled: PropTypes.bool,
    type: PropTypes.oneOf(['button', 'submit', 'reset']),
    size: PropTypes.oneOf(['small', 'medium', 'large'])
}

export default Button;
