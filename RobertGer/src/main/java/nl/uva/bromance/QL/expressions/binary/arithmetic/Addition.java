package nl.uva.bromance.QL.expressions.binary.arithmetic;

import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;

public class Addition extends ArithmeticExpression
{
    public Addition(Expression lhs, Expression rhs, int lineNumber)
    {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public NumberPrimitive evaluate(SymbolTable s)
    {
        NumberPrimitive lhs = (NumberPrimitive) this.lhs.evaluate(s);
        NumberPrimitive rhs = (NumberPrimitive) this.rhs.evaluate(s);
        return lhs.addition(rhs, getLineNumber());
    }
}
