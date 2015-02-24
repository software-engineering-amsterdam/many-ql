package com.form.language.ast.expression.math;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;

public class Negation extends UnaryExpression implements Expression {
	
	public Negation(Expression value, Token tokenInfo) {
		super(value, tokenInfo);
	}

	@Override
	public GenericValue<Integer> evaluate() {		
		return new IntValue(-((IntValue)value.evaluate()).getValue());
	}

	@Override
	public Type getType() {
		if(value.getType().isIntType()) return new IntType();
		return new ErrorType();
	}
	
	
}
