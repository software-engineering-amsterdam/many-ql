package nl.uva.bromance.AST.Conditionals;

import nl.uva.bromance.AST.Exceptions.InvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public class PlusOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) throws InvalidOperandException {
        if (!(one instanceof IntResult) || !(two instanceof IntResult)){
            throw new InvalidOperandException();
        } else {
            IntResult intResultOne = (IntResult) one;
            IntResult intResultTwo = (IntResult) two;
            return intResultOne.add(intResultTwo);
        }
    }
}
