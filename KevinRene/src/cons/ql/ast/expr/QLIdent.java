package cons.ql.ast.expr;

public class QLIdent extends QLType {
	private final String value;
	
	public QLIdent(String value) {
		this.value = value;
	}

	public String show() {
		return this.value;
	}
}
