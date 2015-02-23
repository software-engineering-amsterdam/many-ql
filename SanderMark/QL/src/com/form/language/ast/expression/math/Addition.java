package com.form.language.ast.expression.math;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.IntValue;

public class Addition extends BinaryExpression implements Expression {
	
	public Addition(Expression left, Expression right) {
		super(left,right);
	}

	@Override
	public IntValue evaluate() {
		return ((IntLiteral)left).evaluate().Addition(((IntLiteral)right).evaluate());
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
