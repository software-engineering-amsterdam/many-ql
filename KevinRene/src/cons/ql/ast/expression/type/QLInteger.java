package cons.ql.ast.expression.type;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLInteger extends QLNumeric {	
	public QLInteger() {}
	
	@Override
	public QLType getType() {
		return new QLInteger();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}
