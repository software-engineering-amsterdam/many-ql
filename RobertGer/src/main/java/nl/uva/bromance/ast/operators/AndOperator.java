package nl.uva.bromance.ast.operators;

import nl.uva.bromance.ast.conditionals.BooleanResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.OperatorVisitor;

public class AndOperator extends Operator {

    @Override
    public Result performOperation(Result one, Result two) {
        BooleanResult intResultOne = (BooleanResult) one;
        BooleanResult intResultTwo = (BooleanResult) two;
        return intResultOne.and(intResultTwo);
    }

    @Override
    public String getOperatorString() {
        return "&&";
    }

    @Override
    public void accept(OperatorVisitor visitor) {
        visitor.visit(this);
    }
}
