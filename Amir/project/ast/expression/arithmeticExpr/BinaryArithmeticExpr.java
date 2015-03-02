package project.ast.expression.arithmeticExpr;

import project.ast.expression.BinaryExpression;
import project.ast.expression.Expression;
import project.ast.value.NumericalTypeValue;
import project.ast.value.TypeValue;

public abstract class BinaryArithmeticExpr implements ArithmeticExpression, BinaryExpression {
	
	public Expression left;
	public Expression right;
	
	public BinaryArithmeticExpr(Expression left, Expression right){
		
		this.left = left;
		this.right = right;	
	}
	
	public TypeValue getType(){
		return new NumericalTypeValue();
	};
	
	
}
