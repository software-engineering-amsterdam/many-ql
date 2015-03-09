package ast.expression.comparison;

import ast.expression.BinaryExpression;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.ChoiceType;

// Greater than or equal to(>=)

public class GreaterEqualExpression extends BinaryExpression {
				
	public GreaterEqualExpression (Expression leftExp, Expression rightExp) {
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
	public ChoiceType getExpressionType() {
		return new ChoiceType();
	}
}



