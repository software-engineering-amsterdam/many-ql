package com.form.language.ast.expression.logic;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.error.Error;
import com.form.language.error.ErrorCollector;

public class And extends BinaryExpression implements Expression {

	public And(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}
	
	@Override
	public BoolValue evaluate() {
		return new BoolValue(((BoolValue)super.left.evaluate()).getValue() && ((BoolValue)super.right.evaluate()).getValue());
	}

	@Override
	public Type getType() {
		Type leftType = left.getType();
		Type rightType = right.getType();
		
		if(leftType.isBoolType() && rightType.isBoolType()) {
			return new BoolType();
		}
		else{
			return new ErrorType();
		}
	}
	
	@Override
	public ErrorCollector getErrors(ErrorCollector errors) {
		Type leftType = left.getType();
		Type rightType = right.getType();
		
		ErrorCollector newErrors = new ErrorCollector(left.getErrors(errors), right.getErrors(errors));

		if(leftType.isBoolType() && rightType.isBoolType()) {
			return newErrors;
		}
		else{
			if(!(leftType.isErrorType() || rightType.isErrorType())){
				Error newError = new Error(tokenInfo, "Expected Boolean && Boolean, but found " + leftType + " && " + rightType);
				newErrors.add(newError);
				return newErrors;
			}
			return newErrors;
		}
	}
}
