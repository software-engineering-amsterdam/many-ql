package org.uva.sea.ql.AST.expression.booleanexpression;

import org.antlr.v4.parse.GrammarTreeVisitor.astOperand_return;
import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.literal.AbstractLiteral;
import org.uva.sea.ql.AST.literal.BooleanLiteral;
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.value.AbstractValue;
import org.uva.sea.ql.AST.value.BooleanValue;
import org.uva.sea.ql.AST.value.IntegerValue;

public class EqualExpression extends BinaryExpression {
	
	public EqualExpression(Expression leftExpression, Expression rightExpression){
		super(leftExpression, rightExpression);
	}
	
	@Override
	public BooleanValue interpretExpression() {
//		return new BooleanValue(leftExpression.interpretExpression().equal(rightExpression.interpretExpression()));
		return new BooleanValue(true);
	}
}
