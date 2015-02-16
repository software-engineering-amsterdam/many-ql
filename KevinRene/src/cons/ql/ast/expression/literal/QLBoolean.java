package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;

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
}
