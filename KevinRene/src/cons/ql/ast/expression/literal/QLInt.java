package cons.ql.ast.expression.literal;

import cons.ql.ast.Visitor;
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

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
