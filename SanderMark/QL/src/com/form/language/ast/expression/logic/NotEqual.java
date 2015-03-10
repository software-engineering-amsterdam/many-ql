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
import com.form.language.memory.Context;

public class NotEqual extends BinaryExpression implements Expression {

	public NotEqual(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}
	
	
	@Override
	public BoolValue evaluate(Context context) {
		return new BoolValue(((IntValue)super.left.evaluate(context)).getValue() != ((IntValue)super.right.evaluate(context)).getValue());
	}

	@Override
	public Type getType(Context context) {
		Type leftType = left.getType(context);
		Type rightType = right.getType(context);
		if(	(leftType.isBoolType() && rightType.isBoolType())
			||(leftType.isIntType() && rightType.isIntType())
			||(leftType.isStringType() && rightType.isStringType())) {
			return new BoolType();

		}		
		else{
			if(!(leftType.isErrorType() || rightType.isErrorType())){
				context.addError(new Error(tokenInfo, "Cannot compare unequal types: " + leftType + " != " + rightType));
			}
			return new ErrorType();
		}
	}
}
