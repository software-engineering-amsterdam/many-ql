package org.uva.sea.ql.AST.expression.booleanexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.literal.BooleanLiteral;
import org.uva.sea.ql.AST.value.BooleanValue;

public class AndExpression extends BinaryExpression {

	private BooleanLiteral leftLiteral = (BooleanLiteral) this.leftExpression;
	private BooleanLiteral rightLiteral = (BooleanLiteral) this.rightExpression;

	public AndExpression(Expression leftExpression, Expression rightExpression){
		super(leftExpression, rightExpression);
	}
	
	@Override
	public BooleanValue interpretExpression() {
		boolean left = leftLiteral.interpretExpression().getValue();
		boolean right = rightLiteral.interpretExpression().getValue();
		boolean result = left && right;
		return new BooleanValue(result);
	}
}
