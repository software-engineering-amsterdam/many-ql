package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;

public class LogicalExpression extends BinaryExpression{

    public LogicalExpression(Evaluable lhs, Evaluable rhs) {
        super(lhs, rhs);
    }

    @Override
    public BooleanPrimitive evaluate() {
        return null;
    }
}
