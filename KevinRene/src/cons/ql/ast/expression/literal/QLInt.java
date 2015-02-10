package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;

public class QLInt extends QLType<Integer> {
	public QLInt() {
		super();
	}
	
	public QLInt(int value) {
		super(value);
	}

	@Override
	public String show() {
		return String.valueOf(value);
	}

	@Override
	public String getName() {
		return "QLInt";
	}
}
