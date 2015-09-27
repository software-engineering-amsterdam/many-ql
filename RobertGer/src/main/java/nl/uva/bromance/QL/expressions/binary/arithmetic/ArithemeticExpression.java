package nl.uva.bromance.QL.expressions.binary.arithmetic;

import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.exceptions.TypeCheckingError;

import java.util.List;

public abstract class ArithemeticExpression extends BinaryExpression {
    public ArithemeticExpression(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    public NumberPrimitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions) {
        super.typeCheckNumberPrimitives(s, exceptions);
        return NumberPrimitive.defaultValue(getLineNumber());
    }
}
