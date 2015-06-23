package qlProject.ast.expression.arithmeticExpr;

import qlProject.ast.expression.IExpression;
import qlProject.ast.expression.IExpressionVisitor;
import qlProject.ast.expression.UnaryExpression;

public class NegationExpr extends UnaryExpression {

	public NegationExpr(IExpression subExpr){
		super(subExpr);
	}


	@Override
	public Object accept(IExpressionVisitor visitor){
		return visitor.visit(this);
	}

}