package com.form.language.ast.expression.math;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.IntValue;
import org.antlr.v4.runtime.Token;

public class Addition extends BinaryExpression implements Expression {
	
	public Addition(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
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
