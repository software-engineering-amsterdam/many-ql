package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.BooleanResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.OperatorVisitor;

/**
 * Created by Ger on 24-2-2015.
 */
public class NotEqualsOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) {
        return ((BooleanResult) one.isEqual(two)).flip();
    }

    @Override
    public String getOperatorString() {
        return "!=";
    }

    @Override
    public void accept(OperatorVisitor visitor) {
        visitor.visit(this);
    }
}
