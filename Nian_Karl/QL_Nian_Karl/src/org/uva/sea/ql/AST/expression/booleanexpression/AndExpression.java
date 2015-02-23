package org.uva.sea.ql.AST.expression.booleanexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.literal.BooleanLiteral;
import org.uva.sea.ql.AST.value.AbstractValue;
import org.uva.sea.ql.AST.value.BooleanValue;
import org.uva.sea.ql.AST.visitor.Visitor;

public class AndExpression extends BinaryExpression {

	private BooleanLiteral leftLiteral = (BooleanLiteral) this.leftExpression;
	private BooleanLiteral rightLiteral = (BooleanLiteral) this.rightExpression;

	public AndExpression(Expression leftExpression, Expression rightExpression){
		super(leftExpression, rightExpression);
		
	}
	
	@Override
	public BooleanValue interpretExpression() {
		BooleanValue leftVal = leftLiteral.interpretExpression();
		BooleanValue rightVal = rightLiteral.interpretExpression();
		return (BooleanValue) leftVal.and(rightVal);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
