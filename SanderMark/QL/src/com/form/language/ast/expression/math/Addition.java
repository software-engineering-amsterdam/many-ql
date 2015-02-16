package com.form.language.ast.expression.math;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.values.IntValue;

public class Addition extends BinaryExpression implements PrimitiveExpression {
	
	public Addition(PrimitiveExpression left, PrimitiveExpression right) {
		super(left,right);
	}

	@Override
	public IntValue evaluate() {
		return ((IntLiteral)left).evaluate().Add(((IntLiteral)right).evaluate());
	}
	
	
}
