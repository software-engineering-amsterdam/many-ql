package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.values.BoolValue;

public class NotEqual extends BinaryExpression implements PrimitiveExpression {

	public NotEqual(PrimitiveExpression left, PrimitiveExpression right) {
		super(left, right);
	}
	
	@Override
	public BoolValue evaluate() {
		return ((IntLiteral)left).evaluate().GreaterThan(((IntLiteral)right).evaluate());
	}

}
