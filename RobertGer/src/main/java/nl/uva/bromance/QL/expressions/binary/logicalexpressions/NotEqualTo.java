package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;

/**
 * Created by Robert on 4-6-2015.
 */
public class NotEqualTo extends BinaryExpression {
    public NotEqualTo(Evaluable lhs, Evaluable rhs) {
        super(lhs, rhs);
    }

    @Override
    public BooleanPrimitive evaluate() {
        Primitive lhs = this.lhs.evaluate();
        Primitive rhs = this.rhs.evaluate();
        return lhs.isNotEqual(rhs);
    }
}
