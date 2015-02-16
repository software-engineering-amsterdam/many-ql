package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;

public class QLString extends QLType<String> {
	public QLString() {
		super();
	}
	
	public QLString(String value) {
		super(value);
	}
	
	@Override
	public String toString() {
		return value;
	}	
}
