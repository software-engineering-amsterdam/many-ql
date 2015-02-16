package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

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
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
}
