package nl.uva.bromance.QL.expressions.binary.arithmetic;

import nl.uva.bromance.QL.expressions.Expression;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.OperationException;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.List;

public abstract class ArithemeticExpression extends BinaryExpression {
    public ArithemeticExpression(Expression lhs, Expression rhs, int lineNumber) {
        super(lhs, rhs, lineNumber);
    }

    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions) {
        //TODO: This is duplicate code: see LogicalExpression.class
        try {
            Primitive lType = lhs.typeCheck(s, exceptions);
            Primitive rType = rhs.typeCheck(s, exceptions);
            checkEquivalence(lType,rType,exceptions);
        } catch (NullPointerException npe) {
            //TODO: The only nullpointer we can get is when a Variable does not exist in the lookup table. So do we have to add this exception?
            exceptions.add(new TypeCheckingError("This might be redundant, so I would like ask Ger his opinion on this."));
        }

        return NumberPrimitive.defaultValue(getLineNumber());
    }

    public void checkEquivalence(Primitive lType, Primitive rType,List<TypeCheckingError> exceptions)
    {
        try {
            NumberPrimitive lhsp = (NumberPrimitive) lType;
            NumberPrimitive rhsp = (NumberPrimitive) rType;
        } catch (ClassCastException cce) {
            exceptions.add(new OperationException("Addition can only be performed on integers see line:" + getLineNumber()));
        }
    }
}
