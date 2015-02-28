package com.form.language.ast.expression.logic;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.IntValue;
import com.form.language.error.Error;
import com.form.language.error.ErrorCollector;

public class LessThan extends BinaryExpression implements Expression {

	public LessThan(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}
	
	
	@Override
	public BoolValue evaluate() {
		return new BoolValue(((IntValue)super.left.evaluate()).getValue() < ((IntValue)super.right.evaluate()).getValue());
	}

	@Override
	public Type getType() {
		if(left.getType().isIntType() && right.getType().isIntType()) return new BoolType();
		return new ErrorType();
	}

	@Override
	public void getErrors(ErrorCollector errors) {
		Type leftType = left.getType();
		Type rightType = right.getType();
		left.getErrors(errors);
		right.getErrors(errors);

		if(leftType.isIntType() && rightType.isIntType()) {
			return;
		}
		else{
			if(!(leftType.isErrorType() || rightType.isErrorType())){
				errors.add(new Error(tokenInfo, "Expected Int < Int, but found " + leftType + " < " + rightType));
				return;
			}
			return;
		}
	}
}
