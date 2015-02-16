package cons.ql.ast.expression.literal;

import cons.ql.ast.Visitor;
import cons.ql.ast.expression.QLType;

public class QLIdent extends QLType<String> {
	public QLIdent() {
		super();
	}
	
	public QLIdent(String value) {
		super(value);
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub		
	}
}
