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

public class And extends BinaryExpression implements Expression {

	public And(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}
	
	@Override
	public BoolValue evaluate(Context context) {
		return new BoolValue(((BoolValue)super.left.evaluate(context)).getValue() && ((BoolValue)super.right.evaluate(context)).getValue());
	}

	@Override
	public Type getType(Context context) {
		Type leftType = left.getType(context);
		Type rightType = right.getType(context);
		
		if(leftType.isBoolType() && rightType.isBoolType()) {
			return new BoolType();
		}
		else{			
			if(!(leftType.isErrorType() || rightType.isErrorType())){
				context.addError(new Error(tokenInfo, "Expected Boolean && Boolean, but found " + leftType + " && " + rightType));
		}
			return new ErrorType();
		}
	}
}
