package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;

/**
 * Created by Robert on 31-5-2015.
 */
public class Or extends BinaryExpression {
    public Or(Evaluable lhs, Evaluable rhs) {
        super(lhs, rhs);
    }

    @Override
    public BooleanPrimitive evaluate() {
        BooleanPrimitive lhs =  (BooleanPrimitive) this.lhs.evaluate();
        BooleanPrimitive rhs =  (BooleanPrimitive) this.rhs.evaluate();
        return lhs.or(rhs);
    }
}
