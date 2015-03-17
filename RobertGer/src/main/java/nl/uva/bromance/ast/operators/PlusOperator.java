package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.exceptions.InvalidOperandException;

/**
 * Created by Ger on 24-2-2015.
 */
public class PlusOperator extends Operator {

    @Override
    public Result performOperation(Result leftHand, Result rightHand) throws InvalidOperandException {
        if (leftHand instanceof IntResult && rightHand instanceof IntResult) {
            IntResult intResultOne = (IntResult) leftHand;
            IntResult intResultTwo = (IntResult) rightHand;
            return intResultOne.add(intResultTwo);
        } else {
            throw new InvalidOperandException();
        }
    }

    @Override
    public String getOperatorString() {
        return "+";
    }

    @Override
    public Operator getNewOperatorOfThisType() {
        return new PlusOperator();
    }
}
