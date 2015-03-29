package uva.sc.ql.atom;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.expression.Expression;

public class StringAtom extends Expression<Object> {

    private String value;

    public StringAtom(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Object accept(IQLExpressionNodeVisitor visitor) {
	return visitor.visit(this);
    }

}
