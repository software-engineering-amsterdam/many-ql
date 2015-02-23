package org.uva.sea.ql.AST.expression.mathexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.value.IntegerValue;

public class MulExpression extends BinaryExpression {
	
	
	public MulExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}
	@Override
	public IntegerValue interpretExpression() {
		
//		 int leftInteger = leftExpression.interpretExpression().getValue();
//		 int rightInteger = leftExpression.interpretExpression().getValue();
		 return new IntegerValue(100);
	}

}