package ast.expression.comparison;

import ast.expression.Binary;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.ChoiceType;

// >

public class GreaterThan extends Binary {
									
	public GreaterThan (Expression leftExp, Expression rightExp) {
		super(leftExp, rightExp);
	}
									
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.getLeftExpression().toString() + " > " + super.getRightExpression().toString();
	}
	
	@Override
	public ChoiceType getType() {
		return new ChoiceType();
	}
}



