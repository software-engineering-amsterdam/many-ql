package nl.uva.bromance.QL.expressions.binary.arithmetic;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;

public class Multiplication extends ArithemeticExpression {
    public Multiplication(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public NumberPrimitive evaluate() {
        NumberPrimitive lhs =  (NumberPrimitive) this.lhs.evaluate();
        NumberPrimitive rhs =  (NumberPrimitive) this.rhs.evaluate();
        return lhs.multiplication(rhs, getLineNumber());
    }
}
