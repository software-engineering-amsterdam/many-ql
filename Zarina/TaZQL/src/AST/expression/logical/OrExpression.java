package ast.expression.logical;

import ast.expression.BinaryExpression;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

// For || 

public class OrExpression extends BinaryExpression {
							
	public OrExpression (Expression leftExp, Expression rightExp) {
		super(leftExp, rightExp);
	}
								
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return this.getLeftExpression().toString() + " || " + this.getRightExpression().toString();
	}
}


