package cons.ql.ast.expr;

public class QLBoolean extends QLType {
	
	private String value;
		
	public QLBoolean(String value) {
		this.value = value;
	}

	@Override
	public String show() {
		return value;
	}
}
