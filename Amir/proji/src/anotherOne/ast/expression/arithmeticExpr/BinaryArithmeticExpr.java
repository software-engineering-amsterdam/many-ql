package anotherOne.ast.expression.arithmeticExpr;

import anotherOne.ast.IGlobalElement;
import anotherOne.ast.expression.Expression;

public abstract class BinaryArithmeticExpr implements ArithmeticExpression {
	
	public ArithmeticExpression left;
	public ArithmeticExpression right;

	public BinaryArithmeticExpr(ArithmeticExpression left, ArithmeticExpression right){
		
		this.left = left;
		this.right = right;	
	}
	
	
}
