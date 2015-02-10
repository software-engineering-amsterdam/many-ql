package cons.ql.ast.expr;

public class QLInt extends QLType {	
	private int value;
		
	public QLInt(int value) {
		this.value = value;
	}

	public String show() {
		return String.valueOf(value);
	}
}
