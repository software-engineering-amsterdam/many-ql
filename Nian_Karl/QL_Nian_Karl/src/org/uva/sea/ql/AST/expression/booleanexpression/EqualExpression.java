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
<<<<<<< HEAD
//		return new BooleanValue(leftExpression.interpretExpression().equal(rightExpression.interpretExpression()));
		return new BooleanValue(true);
=======
		boolean left = leftLiteral.interpretExpression().getValue();
		boolean right = rightLiteral.interpretExpression().getValue();
		boolean result = left == right;
		return new BooleanValue(result);
>>>>>>> 2ff1850cf0b0505b45f85d628e7f2ebddba5d66e
	}
}
