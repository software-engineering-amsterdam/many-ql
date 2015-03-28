package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.exceptions.TypecheckingInvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public class MultiplyOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) throws TypecheckingInvalidOperandException {
        if (!(one instanceof IntResult) || !(two instanceof IntResult)) {
            throw new TypecheckingInvalidOperandException("Can only perform operation on two integers");
        } else {
            IntResult intResultOne = (IntResult) one;
            IntResult intResultTwo = (IntResult) two;
            return intResultOne.multiply(intResultTwo);
        }
    }

    @Override
    public String getOperatorString() {
        return "*";
    }

    @Override
    public Operator getNewOperatorOfThisType() {
        return new MultiplyOperator();
    }
}
