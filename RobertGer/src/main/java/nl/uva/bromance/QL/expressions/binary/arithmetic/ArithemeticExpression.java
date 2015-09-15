package nl.uva.bromance.QL.expressions.binary.arithmetic;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;

/**
 * Created by Robert on 9/15/2015.
 */
public class ArithemeticExpression extends BinaryExpression {
    public ArithemeticExpression(Evaluable lhs, Evaluable rhs) {
        super(lhs, rhs);
    }

    @Override
    public NumberPrimitive evaluate() {
        return null;
    }
}
