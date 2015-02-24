package org.uva.sea.ql.AST.expression.mathexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.visitor.Visitor;

public class AddExpression extends BinaryExpression {

	public AddExpression(Expression leftExpression,
			Expression rightExpression) {
		super(leftExpression, rightExpression);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
	
}