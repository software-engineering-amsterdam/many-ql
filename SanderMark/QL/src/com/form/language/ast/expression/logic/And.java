package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.expression.literal.BoolLiteral;
import com.form.language.ast.values.BoolValue;

public class And extends BinaryExpression implements PrimitiveExpression {

	public And(PrimitiveExpression left, PrimitiveExpression right) {
		super(left, right);
	}
	
	@Override
	public BoolValue evaluate() {
		return ((BoolLiteral)left).evaluate().And(((BoolLiteral)right).evaluate());
	}

	@Override
	public Boolean typeCorrect(Error e) {
		// TODO Auto-generated method stub
		return null;
	}

}
