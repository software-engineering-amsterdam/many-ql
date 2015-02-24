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
			if(!leftType.isErrorType() || !rightType.isErrorType()){
				ErrorCollector.add(new Error(tokenInfo, "Expected Boolean && Boolean, but found " + leftType + " && " + rightType));
				int count = 0;
				while(ErrorCollector.getErrorCollection().hasNext()){
					count += 1;
				}
				System.out.println(count);
			}
			return new ErrorType();
		}
	}
}
