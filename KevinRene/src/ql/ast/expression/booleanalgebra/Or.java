package ql.ast.expression.booleanalgebra;

import ql.ast.Expression;
import ql.ast.QLType;
import ql.ast.expression.Binary;
import ql.ast.type.QLBoolean;
import ql.ast.visitor.ExpressionVisitor;

public class Or extends Binary {
	public Or(Expression left, Expression right) {
		super(left, right, "||");
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public QLType getType() {
		return new QLBoolean();
	}
}
