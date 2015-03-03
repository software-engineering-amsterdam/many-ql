package ql.ast.expression.relational;

import ql.ast.Expression;
import ql.ast.expression.QLType;
import ql.ast.expression.Unary;
import ql.ast.expression.type.QLBoolean;
import ql.ast.visitor.Visitor;

public class Not extends Unary {
	public Not(Expression operand) {
		super(operand, "!");
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
