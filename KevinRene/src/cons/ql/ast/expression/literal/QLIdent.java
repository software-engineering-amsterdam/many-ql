package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;

public class QLIdent extends QLType<String> {
	public QLIdent() {
		super();
	}
	
	public QLIdent(String value) {
		super(value);
	}

	@Override
	public String show() {
		return value;
	}

	@Override
	public String getName() {
		return "QLIdent";
	}
}
