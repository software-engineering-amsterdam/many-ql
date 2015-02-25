package nl.uva.bromance.AST.Conditionals;

import nl.uva.bromance.AST.Exceptions.InvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public class OrOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) throws InvalidOperandException {
        if (!(one instanceof BooleanResult) || !(two instanceof BooleanResult)){
            throw new InvalidOperandException();
        } else {
            BooleanResult intResultOne = (BooleanResult) one;
            BooleanResult intResultTwo = (BooleanResult) two;
            return intResultOne.or(intResultTwo);
        }
    }
}
