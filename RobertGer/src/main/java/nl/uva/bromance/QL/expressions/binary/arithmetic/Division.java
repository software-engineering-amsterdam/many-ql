package nl.uva.bromance.QL.expressions.binary.arithmetic;

import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;

public class Division extends ArithmeticExpression {
    public Division(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public NumberPrimitive evaluate(SymbolTable s) {
        NumberPrimitive lhs = (NumberPrimitive) this.lhs.evaluate(s);
        NumberPrimitive rhs = (NumberPrimitive) this.rhs.evaluate(s);
        return lhs.division(rhs, getLineNumber());
    }
}
