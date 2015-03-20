package uva.sc.ql.atom;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.expression.Expression;

public class NumberAtom extends Expression<Object> {

    Double value;

    public NumberAtom(Double value) {
	this.value = (value != null) ? value : 0.;
    }

    public Double getValue() {
	return value;
    }

    public String toString() {
	return String.valueOf(value);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Object accept(IQLExpressionNodeVisitor visitor) {
	return visitor.visit(this);
    }
}
