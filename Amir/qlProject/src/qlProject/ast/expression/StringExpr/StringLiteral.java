package qlProject.ast.expression.StringExpr;

import qlProject.ast.expression.IExpression;
import qlProject.ast.expression.IExpressionVisitor;

public class StringLiteral implements IExpression {
	
	private final String str;
	
	public StringLiteral (String str){
		this.str = str;
	}

	
	public String getValue (){
		return str;
	}

	@Override
	public Object accept(IExpressionVisitor visitor){
		return visitor.visit(this);
	}
	
}