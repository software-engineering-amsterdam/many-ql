package org.uva.sea.ql.AST.expression.mathexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.value.IntegerValue;
import org.uva.sea.ql.AST.visitor.Visitor;

public class SubExpression extends BinaryExpression {
	// private NumberLiteral leftLiteral = (NumberLiteral) this.leftExpression;
	// private NumberLiteral rightLiteral = (NumberLiteral)
	// this.rightExpression;

	public SubExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}