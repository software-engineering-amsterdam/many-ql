package com.form.language.ast.expression.math;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;

public class Modulus extends BinaryExpression implements Expression {
	
	public Modulus(Expression left, Expression right) {
		super(left,right);
	}

	@Override
	public GenericValue<Integer> evaluate() {
		return new IntValue(((IntValue)super.left).evaluate() % ((IntValue)super.right).evaluate());
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
