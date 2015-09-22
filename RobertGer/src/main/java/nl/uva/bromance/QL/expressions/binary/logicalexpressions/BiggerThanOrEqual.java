package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;

public class BiggerThanOrEqual extends LogicalExpression {
    public BiggerThanOrEqual(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive evaluate() {
        NumberPrimitive lhs =  (NumberPrimitive) this.lhs.evaluate();
        NumberPrimitive rhs =  (NumberPrimitive) this.rhs.evaluate();
        return lhs.biggerThanOrEqual(rhs, getLineNumber());
    }
}
