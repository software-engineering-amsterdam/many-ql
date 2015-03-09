package com.form.language.ast.expression.logic;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.error.Error;
import com.form.language.memory.Context;

public class Or extends BinaryExpression implements Expression {

	public Or(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}
	
	
	@Override
	public BoolValue evaluate(Context mem) {
		return new BoolValue(((BoolValue)super.left.evaluate(mem)).getValue() || ((BoolValue)super.right.evaluate(mem)).getValue());
	}

	@Override
	public Type getType(Context mem) {
		Type leftType = left.getType(mem);
		Type rightType = right.getType(mem);
		if(leftType.isBoolType() && rightType.isBoolType()) {
			return new BoolType();
		}		
		else{
			if(!(leftType.isErrorType() || rightType.isErrorType())){
				mem.addError(new Error(tokenInfo, "Expected Boolean || Boolean, but found " + leftType + " || " + rightType));
			}
			return new ErrorType();
		}
	}
	
//	@Override
//	public void getErrors(ErrorCollector errors) {
//		Type leftType = left.getType();
//		Type rightType = right.getType();
//		left.getErrors(errors);
//		right.getErrors(errors);
//
//		if(leftType.isBoolType() && rightType.isBoolType()) {
//			return;
//		}
//		else{
//			if(!(leftType.isErrorType() || rightType.isErrorType())){
//				errors.add(new Error(tokenInfo, "Expected Boolean || Boolean, but found " + leftType + " || " + rightType));
//				return;
//			}
//			return;
//		}
//	}
}
