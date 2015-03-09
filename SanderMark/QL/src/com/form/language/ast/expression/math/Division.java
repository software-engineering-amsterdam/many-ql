package com.form.language.ast.expression.math;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;
import com.form.language.error.Error;
import com.form.language.memory.Context;

public class Division extends BinaryExpression implements Expression {

	public Division(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}

	@Override
	public GenericValue<Integer> evaluate(Context mem) {
		return new IntValue(((IntValue)super.left.evaluate(mem)).getValue() / ((IntValue)super.right.evaluate(mem)).getValue());
	}

	@Override
	public Type getType(Context mem) {
		Type leftType = left.getType(mem);
		Type rightType = right.getType(mem);
		if(leftType.isIntType() && rightType.isIntType()){
			return new IntType();
		}
		else{
			if(!(leftType.isErrorType() || rightType.isErrorType())){
				mem.addError(new Error(tokenInfo, "Expected Int / Int, but found " + leftType + " / " + rightType));
			}
			return new ErrorType();
		}
	}
//	
//	@Override
//	public void getErrors(ErrorCollector errors) {
//		Type leftType = left.getType();
//		Type rightType = right.getType();
//		left.getErrors(errors);
//		right.getErrors(errors);
//
//		if(leftType.isIntType() && rightType.isIntType()) {
//			return;
//		}
//
//	}
}
