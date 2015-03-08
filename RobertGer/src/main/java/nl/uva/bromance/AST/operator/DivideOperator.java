package nl.uva.bromance.ast.operator;

import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.exceptions.InvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public class DivideOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) throws InvalidOperandException {
        if (!(one instanceof IntResult) || !(two instanceof IntResult)){
            throw new InvalidOperandException();
        } else {
            IntResult intResultOne = (IntResult) one;
            IntResult intResultTwo = (IntResult) two;
            return intResultOne.divide(intResultTwo);
        }
    }
}
