package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.OperatorVisitor;

public class EqualsOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) {
        return one.isEqual(two);
    }

    @Override
    public String getOperatorString() {
        return "==";
    }

    @Override
    public void accept(OperatorVisitor visitor) {
        visitor.visit(this);
    }
}
