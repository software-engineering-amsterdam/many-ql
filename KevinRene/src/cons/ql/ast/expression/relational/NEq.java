package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.visitor.Visitor;

public class NEq extends Binary {
	public NEq(Expression left, Expression right) {
		super(left, right, "!=");
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
	
	@Override
	public QLType getType() {
		return new QLBoolean();
	}
}
