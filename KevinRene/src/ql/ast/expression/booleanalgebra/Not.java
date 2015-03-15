package ql.ast.expression.booleanalgebra;

import ql.ast.Expression;
import ql.ast.QLType;
import ql.ast.expression.Unary;
import ql.ast.type.QLBoolean;
import ql.ast.visitor.ExpressionVisitor;

public class Not extends Unary {
	public Not(Expression operand) {
		super(operand, "!");
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
