import React from 'react';
import PropTypes from 'prop-types'

const Button = ({
    children,
    disabled = false,
    type = 'button',
    onClick
}) => {
    return (
        <button type={type} disabled={disabled} onClick={onClick}> 
            {children}
        </button>
    );
}

Button.propTypes = {
    children: PropTypes.node.isRequired,
    onclick: PropTypes.func,
    disabled: PropTypes.bool,
    type: PropTypes.oneOf(['button', 'submit', 'reset']),
    onClick: PropTypes.func
}

export default Button;
