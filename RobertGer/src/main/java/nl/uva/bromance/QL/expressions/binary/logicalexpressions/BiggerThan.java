package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;

public class BiggerThan extends LogicalExpression {
    public BiggerThan(Evaluable lhs, Evaluable rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive evaluate() {
        NumberPrimitive lhs =  (NumberPrimitive) this.lhs.evaluate();
        NumberPrimitive rhs =  (NumberPrimitive) this.rhs.evaluate();
        return lhs.biggerThan(rhs, getLineNumber());
    }
}
