package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;

public class Equal extends BinaryExpression implements Expression {

	public Equal(Expression left, Expression right) {
		super(left, right);
	}
	
	@Override
	public BoolValue evaluate() {
		return ((IntLiteral)left).evaluate().Equal(((IntLiteral)right).evaluate());
	}

	@Override
	public Type getType() {
		if(left.getType().isIntType() && right.getType().isIntType()) return new BoolType();
		return new ErrorType();
	}

}
