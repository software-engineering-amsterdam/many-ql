package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLBoolean extends QLType<String> {
	public QLBoolean() {
		super();
	}
	
	public QLBoolean(String value) {
		super(value);
	}

	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
}
