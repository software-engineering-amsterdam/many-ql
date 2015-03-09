package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.exceptions.InvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public class EqualsOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) throws InvalidOperandException {
        if (one.getClass() != two.getClass()) {
            throw new InvalidOperandException();
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
