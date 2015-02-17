package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.values.BoolValue;

public class LessThanOrEqual extends BinaryExpression implements PrimitiveExpression {

	public LessThanOrEqual(PrimitiveExpression left, PrimitiveExpression right) {
		super(left, right);
	}
	
	@Override
	public BoolValue evaluate() {
		return ((IntLiteral)left).evaluate().LessThanOrEqual(((IntLiteral)right).evaluate());
	}

}