package ast.expression.comparison;

import ast.expression.Binary;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.ChoiceType;

// For ==

public class Equal extends Binary {
						
	public Equal (Expression leftExp, Expression rightExp) {
		super (leftExp, rightExp);
	}
				
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return this.getLeftExpression().toString() + " == " + this.getRightExpression().toString();
	}

	@Override
	public ChoiceType getType() {
		return new ChoiceType();
	}
}


