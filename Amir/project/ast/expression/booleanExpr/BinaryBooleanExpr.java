package project.ast.expression.booleanExpr;

import project.ast.expression.BinaryExpression;
import project.ast.expression.Expression;
import project.ast.value.BooleanTypeValue;
import project.ast.value.TypeValue;


public abstract class BinaryBooleanExpr implements BooleanExpression, BinaryExpression {
	// remove this class?
	public Expression left;
	public Expression right;

	public BinaryBooleanExpr(Expression left, Expression right){
		
		this.left = left;
		this.right = right;	
	}

	@Override
	public TypeValue getType(){
		return new BooleanTypeValue();
	};
//	public boolean isBoolean();
}
