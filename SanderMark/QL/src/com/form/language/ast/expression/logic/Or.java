package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.expression.literal.BoolLiteral;
import com.form.language.ast.values.BoolValue;

public class Or extends BinaryExpression implements PrimitiveExpression {

	public Or(PrimitiveExpression left, PrimitiveExpression right) {
		super(left, right);
	}
	
	@Override
	public BoolValue evaluate() {
		return ((BoolLiteral)left).evaluate().Or(((BoolLiteral)right).evaluate());
	}

}
