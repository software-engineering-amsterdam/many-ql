package uva.sc.ql.atom;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.expression.Expression;

@SuppressWarnings({ "rawtypes" })
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

    public Object accept(IQLExpressionNodeVisitor visitor) {
	return visitor.visit(this);
    }
    
    @Override
    public boolean equals(Object obj) {
	if (obj == null )
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ID other = (ID) obj;
	return value.equals(other.value);
    }
    
    @Override
    public int hashCode() {
	return value.hashCode();
    }

}
