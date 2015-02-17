package cons.ql.ast.expression.type;

import java.util.Arrays;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLInt extends QLNumeric {
	
	int value;
	boolean defined;
	
	public QLInt() {}
	
	public QLInt(int value) {
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
		return new QLInt();
	}
}
