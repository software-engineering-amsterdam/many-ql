package uva.sc.ql.atom;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.expression.Expression;

public class ID extends Expression {

    String value;

    public ID(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }

    public String toString() {
	return "[ID]: " + this.value;
    }

    @Override
    public Object accept(IQLExpressionNodeVisitor visitor) {
	return visitor.visit(this);
    }

}
