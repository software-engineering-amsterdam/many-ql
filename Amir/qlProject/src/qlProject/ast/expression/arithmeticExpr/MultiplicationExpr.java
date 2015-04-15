package qlProject.ast.expression.arithmeticExpr;

import qlProject.ast.expression.BinaryExpression;
import qlProject.ast.expression.IExpression;
import qlProject.ast.expression.IExpressionVisitor;

public class MultiplicationExpr extends BinaryExpression {

	public MultiplicationExpr(IExpression left, IExpression right) {
		super(left, right);
	}

	
	@Override
	public Object accept(IExpressionVisitor visitor){
		return visitor.visit(this);
	}

}