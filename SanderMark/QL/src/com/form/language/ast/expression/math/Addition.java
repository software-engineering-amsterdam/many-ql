package com.form.language.ast.expression.math;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.values.IntValue;

public class Addition extends BinaryExpression implements PrimitiveExpression {
	
	public Addition(PrimitiveExpression left, PrimitiveExpression right) {
		super(left,right);
	}
	
	IntLiteral left = (IntLiteral) super.left;
	IntLiteral right = (IntLiteral) super.right;
	

	@Override
	public IntValue evaluate() {
		return right.evaluate().Add(left.evaluate());
	}
	
	
}
