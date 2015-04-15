package qlProject.ast.expression.arithmeticExpr;

import qlProject.ast.expression.IExpression;
import qlProject.ast.expression.IExpressionVisitor;

public class IntLiteral implements IExpression {

	private final int value;

	public IntLiteral (int value){
		this.value = value;
	}

	
	public int getValue (){
		return value;
	}
	
	@Override
	public Object accept(IExpressionVisitor visitor){
		return visitor.visit(this);
	}

}