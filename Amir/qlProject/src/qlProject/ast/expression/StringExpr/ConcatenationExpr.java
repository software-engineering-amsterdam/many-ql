package qlProject.ast.expression.StringExpr;

import qlProject.ast.expression.BinaryExpression;
import qlProject.ast.expression.IExpression;
import qlProject.ast.expression.IExpressionVisitor;

public class ConcatenationExpr extends BinaryExpression {

	public ConcatenationExpr(IExpression left, IExpression right) {
		super(left, right);
	}


	@Override
	public Object accept(IExpressionVisitor visitor){
		return visitor.visit(this);
	}

}