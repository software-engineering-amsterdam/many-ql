package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.exceptions.TypeCheckingError;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.exceptions.OperationException;

import java.util.List;

public class EqualTo extends LogicalExpression
{
    public EqualTo(Expression lhs, Expression rhs, int lineNumber)
    {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive evaluate(SymbolTable s)
    {
        Primitive lhs = this.lhs.evaluate(s);
        Primitive rhs = this.rhs.evaluate(s);
        return lhs.isEqual(rhs, getLineNumber());
    }

    @Override
    public BooleanPrimitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions)
    {
        Primitive lType = lhs.typeCheck(s, exceptions);
        Primitive rType = rhs.typeCheck(s, exceptions);

        if(lType.getClass() != rType.getClass())
            exceptions.add(new OperationException("'==' operation on operators of differing types @ line:"+getLineNumber()));

        return BooleanPrimitive.defaultValue(getLineNumber());
    }
}
