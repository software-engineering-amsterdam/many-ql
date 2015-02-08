package anotherOne.ast.expression.booleanExpr;

import anotherOne.ast.expression.Expression;


public abstract class BinaryBooleanExpr implements BooleanExpression {
	// remove this class?
	public Expression left;
	public Expression right;

	public BinaryBooleanExpr(Expression left, Expression right){
		
		this.left = left;
		this.right = right;	
	}

}
