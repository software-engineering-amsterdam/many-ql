package cons.ql.ast.expression.type;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLFloat extends QLNumeric {
	
	float value;
	boolean defined;
	
	public QLFloat() {
	}
	
	public QLFloat(float value) {
		this.value = value;
		this.defined = true;
	}

	@Override
	public String toString() {		
		return String.valueOf(value);
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}

	@Override
	public QLType getType() {
		return new QLFloat();
	}
}
