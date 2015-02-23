package com.form.language.ast.expression.math;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;

public class Substraction extends BinaryExpression implements PrimitiveExpression {
	
	public Substraction(PrimitiveExpression left, PrimitiveExpression right) {
		super(left,right);
	}

	@Override
	public GenericValue<Integer> evaluate() {
		return new IntValue(((IntValue)super.left).evaluate() - ((IntValue)super.right).evaluate());
	}

	@Override
	public Boolean typeCorrect(Error e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
