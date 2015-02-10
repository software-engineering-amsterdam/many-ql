package cons.ql.ast.expr;

public class QLString extends QLType {
	
	private String value;
		
	public QLString(String value) {
		this.value = value;
	}

	@Override
	public String show() {
		return value;
	}
}
