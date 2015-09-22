package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;

public class NotEqualTo extends LogicalExpression {
    public NotEqualTo(Evaluable lhs, Evaluable rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive evaluate() {
        Primitive lhs = this.lhs.evaluate();
        Primitive rhs = this.rhs.evaluate();
        return lhs.isNotEqual(rhs, getLineNumber());
    }
}
