package ast.expression.comparison;

import ast.expression.Binary;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.ChoiceType;

// Greater than or equal to(>=)

public class GreaterEqual extends Binary {
				
	public GreaterEqual (Expression leftExp, Expression rightExp) {
		super(leftExp, rightExp);
	}
									
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return this.getLeftExpression().toString() + " >= " + this.getRightExpression().toString();
	}
	
	@Override
	public ChoiceType getType() {
		return new ChoiceType();
	}
}



