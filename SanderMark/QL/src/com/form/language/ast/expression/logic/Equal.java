package com.form.language.ast.expression.logic;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.IntValue;
import com.form.language.ast.values.StringValue;
import com.form.language.error.Error;
import com.form.language.memory.Context;

public class Equal extends BinaryExpression implements Expression {

	public Equal(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}
	
	
	@Override
	public BoolValue evaluate(Context context) {
		if(this.getType(context).isIntType()){
			return new BoolValue(((IntValue)super.left.evaluate(context)).getValue() == ((IntValue)super.right.evaluate(context)).getValue());
		}
		if(this.getType(context).isBoolType()){
			return new BoolValue(((BoolValue)super.left.evaluate(context)).getValue() == ((BoolValue)super.right.evaluate(context)).getValue());
		}
		if(this.getType(context).isStringType()){
			return new BoolValue(((StringValue)super.left.evaluate(context)).getValue() == ((StringValue)super.right.evaluate(context)).getValue());
		}
		return null;
	}

	@Override
	//TODO: improve this code
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
				context.addError(new Error(tokenInfo, "Cannot compare unequal types: " + leftType + " == " + rightType));
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
//		if(	(leftType.isBoolType() && rightType.isBoolType())
//		  ||(leftType.isIntType() && rightType.isIntType())
//		  ||(leftType.isStringType() && rightType.isStringType())) {
//			return;
//		}
//		else{
//			if(!(leftType.isErrorType() || rightType.isErrorType())){
//				errors.add(new Error(tokenInfo, "Cannot compare unequal types: " + leftType + " == " + rightType));
//				return;
//			}
//			return;
//		}
//	}
}
