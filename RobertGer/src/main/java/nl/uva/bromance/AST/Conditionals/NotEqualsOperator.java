package nl.uva.bromance.AST.Conditionals;

import nl.uva.bromance.AST.Exceptions.InvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public class NotEqualsOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) throws InvalidOperandException {
        if (one.getClass() != two.getClass()){
            throw new InvalidOperandException();
        } else {
            return ((BooleanResult) one.isEqual(two)).flip();
        }
    }
}
