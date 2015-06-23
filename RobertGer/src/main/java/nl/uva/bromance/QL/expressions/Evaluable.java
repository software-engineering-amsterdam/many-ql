package nl.uva.bromance.QL.expressions;

import nl.uva.bromance.QL.expressions.unary.Primitive;

public interface Evaluable {

    Primitive evaluate();
}
