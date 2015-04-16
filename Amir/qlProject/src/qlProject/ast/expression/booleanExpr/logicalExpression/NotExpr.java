package qlProject.ast.expression.booleanExpr.logicalExpression;

import qlProject.ast.expression.IExpression;
import qlProject.ast.expression.IExpressionVisitor;
import qlProject.ast.expression.UnaryExpression;

public class NotExpr extends UnaryExpression {

	public NotExpr(IExpression subExpr) {
		super(subExpr);
	}

	@Override
	public Object accept(IExpressionVisitor visitor){
		return visitor.visit(this);
	}

}