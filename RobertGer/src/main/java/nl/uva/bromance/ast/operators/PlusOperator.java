package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.OperatorVisitor;

/**
 * Created by Ger on 24-2-2015.
 */
public class PlusOperator extends Operator {

    @Override
    public Result performOperation(Result leftHand, Result rightHand) {
        IntResult intResultOne = (IntResult) leftHand;
        IntResult intResultTwo = (IntResult) rightHand;
        return intResultOne.add(intResultTwo);
    }

    @Override
    public String getOperatorString() {
        return "+";
    }

    @Override
    public Operator getNewOperatorOfThisType() {
        return new PlusOperator();
    }

    @Override
    public void accept(OperatorVisitor visitor) {
        visitor.visit(this);
    }
}
