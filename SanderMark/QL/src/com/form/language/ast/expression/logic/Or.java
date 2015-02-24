package com.form.language.ast.expression.logic;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;

public class Or extends BinaryExpression implements Expression {

	public Or(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}
	
	
	@Override
	public BoolValue evaluate() {
		return new BoolValue(((BoolValue)super.left.evaluate()).getValue() || ((BoolValue)super.right.evaluate()).getValue());
	}

	@Override
	public Type getType() {
		if(left.getType().isBoolType() && right.getType().isBoolType()) return new BoolType();
		return new ErrorType();
	}

}
