package ql.ast.expression.arithmetic;

import ql.ast.Expression;
import ql.ast.QLType;
import ql.ast.expression.Binary;
import ql.ast.type.QLNumeric;
import ql.ast.visitor.ExpressionVisitor;

public class Subtract extends Binary {
	public Subtract(Expression left, Expression right) {
		super(left, right, "-");
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
