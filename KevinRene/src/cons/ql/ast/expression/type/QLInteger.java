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
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
}
