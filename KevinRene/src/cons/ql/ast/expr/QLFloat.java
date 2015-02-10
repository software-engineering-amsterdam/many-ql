package cons.ql.ast.expr;

public class QLFloat extends QLType {
	
	private int value;
		
	public QLFloat(int value) {
		this.value = value;
	}

	@Override
	public String show() {
		return String.valueOf(value);
	}
}
