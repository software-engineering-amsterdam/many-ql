package nl.uva.bromance.ast.operator;

import nl.uva.bromance.ast.conditionals.BooleanResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.exceptions.InvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public class AndOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) throws InvalidOperandException {
        if (!(one instanceof BooleanResult) || !(two instanceof BooleanResult)) {
            throw new InvalidOperandException();
        } else {
            BooleanResult intResultOne = (BooleanResult) one;
            BooleanResult intResultTwo = (BooleanResult) two;
            return intResultOne.and(intResultTwo);
        }
    }

    @Override
    public String getOperatorString() {
        return "&&";
    }
}
