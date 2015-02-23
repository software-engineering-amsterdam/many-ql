package ast.expression.arithmetic;

import ast.expression.BinaryExpression;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public class AdditionExpression extends BinaryExpression {
			
	public AdditionExpression (Expression leftExp, Expression rightExp) {
		super(leftExp, rightExp);
	}
		
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpression().toString() +  " + " + this.getRightExpression().toString();
	}	
}


