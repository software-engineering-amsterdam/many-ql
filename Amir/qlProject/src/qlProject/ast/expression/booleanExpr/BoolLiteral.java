package qlProject.ast.expression.booleanExpr;

import qlProject.ast.expression.IExpression;
import qlProject.ast.expression.IExpressionVisitor;

public class BoolLiteral implements IExpression {
	
	private final boolean value;
	
	public BoolLiteral (boolean value){
		this.value = value;
	}


	public boolean getValue (){
		return this.value;
	}

	@Override
	public Object accept(IExpressionVisitor visitor) {
		return visitor.visit(this);
	}
}