package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.exceptions.QLError;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.exceptions.OperationException;

import java.util.List;

public class NotEqualTo extends LogicalExpression {
    public NotEqualTo(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive evaluate(SymbolTable s) {
        Primitive lhs = this.lhs.evaluate(s);
        Primitive rhs = this.rhs.evaluate(s);
        return lhs.isNotEqual(rhs, getLineNumber());
    }

    @Override
    public BooleanPrimitive typeCheck(SymbolTable s, List<QLError> exceptions) {
        Primitive lType = lhs.typeCheck(s, exceptions);
        Primitive rType = rhs.typeCheck(s,exceptions);

        if(lType.getClass() != rType.getClass())
        {
            exceptions.add(new OperationException("Not Equals operation can only be performed on operands of the same type, see line:"+getLineNumber()));
        }

        return BooleanPrimitive.defaultValue(getLineNumber());
    }
}
