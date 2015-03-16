package ast.expression.arithmetic;

import ast.expression.Binary;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.IntegerType;


public class Multiplication extends Binary {
	
	public Multiplication (Expression leftExp, Expression rightExp) {
		super(leftExp, rightExp);
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString(){
		return this.getLeftExpression().toString() +  " * " + this.getRightExpression().toString();
	}
	
	@Override
	public IntegerType getType() {
		return new IntegerType();
	}
}
