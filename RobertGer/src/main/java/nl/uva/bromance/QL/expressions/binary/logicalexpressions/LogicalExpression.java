package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.OperationException;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.List;

public abstract class LogicalExpression extends BinaryExpression {

    public LogicalExpression(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    @Override
    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions){

        try {
            Primitive lType = lhs.typeCheck(s, exceptions);
            Primitive rType = rhs.typeCheck(s, exceptions);
            checkEquivalence(lType, rType, exceptions);
        }
        catch (NullPointerException npe){
            //TODO: The only nullpointer we can get is when a Variable does not exist in the lookup table. So do we have to add this exception?
            exceptions.add(new TypeCheckingError("This might be redundant, so I would like ask Ger his opinion on this."));
        }

        return new BooleanPrimitive(false, getLineNumber());
    }

    private void checkEquivalence(Primitive lType, Primitive rType, List<TypeCheckingError> exceptions){
        try {
            BooleanPrimitive lhsp = (BooleanPrimitive) lType;
            BooleanPrimitive rhsp = (BooleanPrimitive) rType;
        } catch (ClassCastException cce) {
            exceptions.add(new OperationException("Logical expressions can only be performed on booleans see line:" + getLineNumber()));
        }
    }
}
