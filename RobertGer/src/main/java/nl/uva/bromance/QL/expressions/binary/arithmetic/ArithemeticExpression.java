package nl.uva.bromance.QL.expressions.binary.arithmetic;

import nl.uva.bromance.QL.exceptions.QLError;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.exceptions.OperationException;
import nl.uva.bromance.QL.exceptions.TypeCheckingError;

import java.util.List;

public abstract class ArithemeticExpression extends BinaryExpression {
    public ArithemeticExpression(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    public NumberPrimitive typeCheck(SymbolTable s, List<QLError> exceptions) {
        //TODO: This is duplicate code: see LogicalExpression.class
        try {
            Primitive lType = lhs.typeCheck(s, exceptions);
            Primitive rType = rhs.typeCheck(s, exceptions);
            super.checkNumberEquivalence(lType, rType, exceptions);
        } catch (NullPointerException npe) {
        }
        return NumberPrimitive.defaultValue(getLineNumber());
    }
}
