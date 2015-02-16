package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLInt extends QLType<Integer> {
	public QLInt() {
		super();
	}
	
	public QLInt(int value) {
		super(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
}
