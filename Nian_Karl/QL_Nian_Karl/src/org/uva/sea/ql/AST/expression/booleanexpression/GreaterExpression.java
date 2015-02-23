package org.uva.sea.ql.AST.expression.booleanexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
<<<<<<< HEAD
import org.uva.sea.ql.AST.value.AbstractValue;
=======
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.value.BooleanValue;
>>>>>>> 2ff1850cf0b0505b45f85d628e7f2ebddba5d66e

public class GreaterExpression extends BinaryExpression {
	
	
<<<<<<< HEAD
	public GreaterExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

=======
	private NumberLiteral leftLiteral = (NumberLiteral) this.leftExpression;
	private NumberLiteral rightLiteral = (NumberLiteral) this.rightExpression;

	public GreaterExpression(Expression leftExpression, Expression rightExpression){
		super(leftExpression, rightExpression);
	}
	
>>>>>>> 2ff1850cf0b0505b45f85d628e7f2ebddba5d66e
	@Override
	public BooleanValue interpretExpression() {
		int left = leftLiteral.interpretExpression().getValue();
		int right = rightLiteral.interpretExpression().getValue();
		boolean result = left > right;
		return new BooleanValue(result);
	}
}
