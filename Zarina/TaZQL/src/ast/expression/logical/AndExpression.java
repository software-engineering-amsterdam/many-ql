package ast.expression.logical;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

// For &&

public class AndExpression extends Expression {
			
	private Expression leftExp, rightExp;
				
	public AndExpression (Expression leftExp, Expression rightExp) {
		this.leftExp = leftExp;
		this.rightExp = rightExp;
	}
				
	public Expression getLeftExp() {
		return leftExp;
	}
				
	public Expression getRightExp() {
		return rightExp;
	}
				
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return getLeftExp() + " && " + getRightExp();
	}

}


