package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;

public class QLFloat extends QLType<Float> {	
	public QLFloat() {
		super();
	}
	
	public QLFloat(float value) {
		super(value);
	}

	@Override
	public String toString() {		
		return String.valueOf(value);
	}
}
