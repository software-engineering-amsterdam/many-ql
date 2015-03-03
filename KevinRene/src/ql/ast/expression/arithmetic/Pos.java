package ql.ast.expression.arithmetic;

import ql.ast.Expression;
import ql.ast.expression.QLType;
import ql.ast.expression.Unary;
import ql.ast.expression.type.QLNumeric;
import ql.ast.visitor.Visitor;

public class Pos extends Unary {
	public Pos(Expression operand) {
		super(operand, "+");
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	@Override
	public QLType getType() {
		return new QLNumeric();
	}
}
