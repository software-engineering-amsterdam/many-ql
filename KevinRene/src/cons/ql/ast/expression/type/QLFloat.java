package cons.ql.ast.expression.type;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLFloat extends QLNumeric {
	public QLFloat() {}
	
	@Override
	public QLType getType() {
		return new QLFloat();
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
}
