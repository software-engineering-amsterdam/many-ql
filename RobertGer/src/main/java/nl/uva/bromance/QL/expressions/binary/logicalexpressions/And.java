package nl.uva.bromance.QL.expressions.binary.logicalexpressions;

import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;

public class And extends BinaryExpression {
    public And(Evaluable lhs, Evaluable rhs) {
        super(lhs, rhs);
    }

    @Override
    public BooleanPrimitive evaluate() {
        BooleanPrimitive lhs =  (BooleanPrimitive) this.lhs.evaluate();
        BooleanPrimitive rhs =  (BooleanPrimitive) this.rhs.evaluate();
        return lhs.and(rhs);
    }
}
