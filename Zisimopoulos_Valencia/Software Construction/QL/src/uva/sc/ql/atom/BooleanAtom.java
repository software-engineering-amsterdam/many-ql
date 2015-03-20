package uva.sc.ql.atom;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.expression.Expression;

public class BooleanAtom extends Expression<Object> {

    final Boolean value;

    public BooleanAtom(boolean value) {
	this.value = new Boolean(value);
    }

    public Boolean getValue() {
	return value;
    }

    public String toString() {
	return "[Boolean]: " + getValue();
    }

    public static BooleanAtom getTrue() {
	return new BooleanAtom(true);
    }

    public static BooleanAtom getFalse() {
	return new BooleanAtom(false);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Object accept(IQLExpressionNodeVisitor visitor) {
	return visitor.visit(this);
    }

}
