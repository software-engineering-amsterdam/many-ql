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
import com.form.language.memory.Memory;

public class Or extends BinaryExpression implements Expression {

	public Or(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}
	
	
	@Override
	public BoolValue evaluate() {
		return new BoolValue(((BoolValue)super.left.evaluate()).getValue() || ((BoolValue)super.right.evaluate()).getValue());
	}

	@Override
	public Type getType() {
		if(left.getType().isBoolType() && right.getType().isBoolType()) return new BoolType();
		return new ErrorType();
	}
	
	@Override
	public void getErrors(ErrorCollector errors) {
		Type leftType = left.getType();
		Type rightType = right.getType();
		left.getErrors(errors);
		right.getErrors(errors);

		if(leftType.isBoolType() && rightType.isBoolType()) {
			return;
		}
		else{
			if(!(leftType.isErrorType() || rightType.isErrorType())){
				errors.add(new Error(tokenInfo, "Expected Boolean || Boolean, but found " + leftType + " || " + rightType));
				return;
			}
			return;
		}
	}


	@Override
	public void fillMemory(Memory memory) {
		// TODO Auto-generated method stub
		
	}

}
