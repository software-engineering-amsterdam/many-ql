package ast.expression.arithmetic;

import ast.expression.BinaryExpression;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.DigitsType;

public class DivisionExpression extends BinaryExpression {
		
	public DivisionExpression (Expression leftExp, Expression rightExp) {
		super( leftExp, rightExp);
	}
			
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
		
	@Override
	public String toString(){
		return this.getLeftExpression().toString() +  " / " + this.getRightExpression().toString();
	}

	@Override
	public DigitsType getExpressionType() {
		return new DigitsType();
	}
}

