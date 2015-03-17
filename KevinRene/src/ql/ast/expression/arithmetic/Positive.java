package ql.ast.expression.arithmetic;

import ql.ast.Expression;
import ql.ast.QLType;
import ql.ast.expression.Unary;
import ql.ast.type.QLNumeric;
import ql.ast.visitor.ExpressionVisitor;

public class Positive extends Unary {
	public Positive(Expression operand) {
		super(operand, "+");
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	@Override
	public QLType getType() {
		return new QLNumeric();
	}
}
