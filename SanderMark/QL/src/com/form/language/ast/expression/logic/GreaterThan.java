package com.form.language.ast.expression.logic;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.IntValue;

public class GreaterThan extends BinaryExpression implements Expression {

	public GreaterThan(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}
	
	
	@Override
	public BoolValue evaluate() {
		return new BoolValue(((IntValue)super.left.evaluate()).getValue() > ((IntValue)super.right.evaluate()).getValue());
	}

	@Override
	public Type getType() {
		if(left.getType().isIntType() && right.getType().isIntType()) return new BoolType();
		return new ErrorType();
	}

}
