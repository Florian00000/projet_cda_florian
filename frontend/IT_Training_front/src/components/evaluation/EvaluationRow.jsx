import React from 'react';
import { formatDateToFrench } from '../../utils/methodsDate';

const EvaluationRow = ({evaluation, isRead}) => {
    return (
        <tr>
            <td style={{width: "25%"}}><input type="checkbox" disabled={isRead} /></td>
            <td style={{width: "75%"}}>{formatDateToFrench(evaluation?.valuationDate)}</td>
        </tr>
    );
}

export default EvaluationRow;
