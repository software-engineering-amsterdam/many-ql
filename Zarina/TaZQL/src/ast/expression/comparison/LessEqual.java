package ast.expression.comparison;

import ast.expression.Binary;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.ChoiceType;

// Less than or equal to(<=)

public class LessEqual extends Binary {
								
	public LessEqual (Expression leftExp, Expression rightExp) {
		super(leftExp, rightExp);
	}
									
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.getLeftExpression().toString() + " <= " + super.getRightExpression().toString();
	}
	
	@Override
	public ChoiceType getType() {
		return new ChoiceType();
	}
}



