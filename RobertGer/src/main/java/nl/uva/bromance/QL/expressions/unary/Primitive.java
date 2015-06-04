package nl.uva.bromance.QL.expressions.unary;
import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;

public abstract class Primitive implements Evaluable{

    public abstract BooleanPrimitive isEqual(Primitive rhs);

    public BooleanPrimitive isNotEqual(Primitive rhs) {
        BooleanPrimitive primitive = isEqual(rhs);
        primitive.invert();
        return primitive;
    }
}

