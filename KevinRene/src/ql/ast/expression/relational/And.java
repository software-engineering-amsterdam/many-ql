package ql.ast.expression.relational;

import ql.ast.Expression;
import ql.ast.expression.Binary;
import ql.ast.expression.QLType;
import ql.ast.expression.type.QLBoolean;
import ql.ast.visitor.Visitor;

public class And extends Binary {	
	public And(Expression left, Expression right) {
		super(left, right, "&&");
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}

	@Override
	public QLType getType() {
		return new QLBoolean();
	}
}
