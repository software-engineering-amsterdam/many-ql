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
	public String toString() {
		return String.valueOf(value);
	}
}
