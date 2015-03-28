package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.exceptions.TypecheckingInvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public class EqualsOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) throws TypecheckingInvalidOperandException {
        if (one.getClass() != two.getClass()) {
            throw new TypecheckingInvalidOperandException("Can only perform operation on the same types");
        } else {
            return one.isEqual(two);
        }
    }

    @Override
    public String getOperatorString() {
        return "==";
    }

    @Override
    public Operator getNewOperatorOfThisType() {
        return new EqualsOperator();
    }
}
