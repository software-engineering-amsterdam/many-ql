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
import com.form.language.memory.RuntimeMemory;
import com.form.language.memory.TypeMemory;

public class NotEqual extends BinaryExpression implements Expression {

	public NotEqual(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}
	
	
	@Override
	public BoolValue evaluate(RuntimeMemory mem) {
		return new BoolValue(((IntValue)super.left.evaluate(mem)).getValue() != ((IntValue)super.right.evaluate(mem)).getValue());
	}

	@Override
	public Type getType(TypeMemory mem) {
		Type leftType = left.getType(mem);
		Type rightType = right.getType(mem);
		if(	(leftType.isBoolType() && rightType.isBoolType())
			||(leftType.isIntType() && rightType.isIntType())
			||(leftType.isStringType() && rightType.isStringType())) {
			return new BoolType();

		}		
		else{
			if(!(leftType.isErrorType() || rightType.isErrorType())){
				mem.addError(new Error(tokenInfo, "Cannot compare unequal types: " + leftType + " != " + rightType));
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
//		if(	(leftType.isBoolType() && rightType.isBoolType())
//		  ||(leftType.isIntType() && rightType.isIntType())
//		  ||(leftType.isStringType() && rightType.isStringType())) {
//			return;
//		}
//		else{
//			if(!(leftType.isErrorType() || rightType.isErrorType())){
//				errors.add(new Error(tokenInfo, "Cannot compare unequal types: " + leftType + " != " + rightType));
//				return;
//			}
//			return;
//		}
//	}
}
