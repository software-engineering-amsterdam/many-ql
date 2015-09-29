package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.exceptions.TypeCheckingError;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;

import java.util.List;

public class SmallerThanOrEqual extends LogicalExpression
{
    public SmallerThanOrEqual(Expression lhs, Expression rhs, int lineNumber)
    {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive evaluate(SymbolTable s)
    {
        NumberPrimitive lhs = (NumberPrimitive) this.lhs.evaluate(s);
        NumberPrimitive rhs = (NumberPrimitive) this.rhs.evaluate(s);
        return lhs.smallerThanOrEqual(rhs, getLineNumber());
    }

    @Override
    public BooleanPrimitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions)
    {
        return super.typeCheckNumberPrimitives(s, exceptions);
    }
}
