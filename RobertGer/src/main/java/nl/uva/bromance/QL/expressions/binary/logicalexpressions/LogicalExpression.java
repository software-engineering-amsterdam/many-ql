package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.exceptions.QLError;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.exceptions.OperationException;
import nl.uva.bromance.QL.exceptions.TypeCheckingError;

import java.util.List;

public abstract class LogicalExpression extends BinaryExpression {

    public LogicalExpression(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public BooleanPrimitive typeCheck(SymbolTable s, List<QLError> exceptions){
        try {
            Primitive lType = lhs.typeCheck(s, exceptions);
            Primitive rType = rhs.typeCheck(s, exceptions);
            checkBooleanEquivalence(lType, rType, exceptions);
        }
        catch (NullPointerException npe){
        }

        return new BooleanPrimitive(false, getLineNumber());
    }

}
