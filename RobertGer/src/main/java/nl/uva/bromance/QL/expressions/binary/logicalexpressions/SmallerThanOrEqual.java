package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;

public class SmallerThanOrEqual extends LogicalExpression {
    public SmallerThanOrEqual(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive evaluate() {
        NumberPrimitive lhs = (NumberPrimitive) this.lhs.evaluate();
        NumberPrimitive rhs = (NumberPrimitive) this.rhs.evaluate();
        return lhs.smallerThanOrEqual(rhs, getLineNumber());
    }
}
