package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;

public class LessThanOrEqual extends BinaryExpression implements Expression {

	public LessThanOrEqual(Expression left, Expression right) {
		super(left, right);
	}
	
	@Override
	public BoolValue evaluate() {
		return ((IntLiteral)left).evaluate().LessThanOrEqual(((IntLiteral)right).evaluate());
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
