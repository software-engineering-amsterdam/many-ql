package nl.uva.bromance.QL.expressions.binary;

import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.exceptions.OperationException;
import nl.uva.bromance.QL.exceptions.QLError;
import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;

import java.util.List;

public abstract class BinaryExpression extends Expression {
    protected Expression lhs;
    protected Expression rhs;

    public BinaryExpression(Expression lhs, Expression rhs, int lineNumber){
        super(lineNumber);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor) {
        lhs.accept(visitor);
        rhs.accept(visitor);
    }

    protected void checkBooleanEquivalence(Primitive lType, Primitive rType, List<QLError> exceptions){
        try {
            BooleanPrimitive lhsp = (BooleanPrimitive) lType;
            BooleanPrimitive rhsp = (BooleanPrimitive) rType;
        } catch (ClassCastException cce) {
            exceptions.add(new OperationException("This expression can only be performed on booleans see line:" + getLineNumber()));
        }
    }

    public void checkNumberEquivalence(Primitive lType, Primitive rType, List<QLError> exceptions){
        try {
            NumberPrimitive lhsp = (NumberPrimitive) lType;
            NumberPrimitive rhsp = (NumberPrimitive) rType;
        } catch (ClassCastException cce) {
            exceptions.add(new OperationException("This expression can only be performed on numbers see line:" + getLineNumber()));
        }
    }

    protected BooleanPrimitive typeCheckNumberPrimitives(SymbolTable s, List<QLError> exceptions){
        try {
            Primitive lType = lhs.typeCheck(s, exceptions);
            Primitive rType = rhs.typeCheck(s, exceptions);
            checkNumberEquivalence(lType, rType, exceptions);
        }
        catch (NullPointerException npe){
            //The only nullpointer we can get is when a Variable does not exist in the lookup table and we already throw an exception there.
        }

        return new BooleanPrimitive(false, getLineNumber());
    }
}
