package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;

public class And extends LogicalExpression {
    public And(Evaluable lhs, Evaluable rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive evaluate() {
        BooleanPrimitive lhs =  (BooleanPrimitive) this.lhs.evaluate();
        BooleanPrimitive rhs =  (BooleanPrimitive) this.rhs.evaluate();
        return lhs.and(rhs,getLineNumber());
    }
}
