package com.form.language.ast.expression.math;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.IntValue;

public class Addition extends BinaryExpression implements Expression {
	
	public Addition(Expression left, Expression right) {
		super(left,right);
	}

	@Override
	public IntValue evaluate() {
		return new IntValue(((IntValue)super.left.evaluate()).getValue() + ((IntValue)super.right.evaluate()).getValue());
	}

	@Override
	public Type getType() {
		if(left.getType().isIntType() && right.getType().isIntType()) return new IntType();
		return new ErrorType();
	}
	
	
}
