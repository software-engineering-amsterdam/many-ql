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
import com.form.language.error.ErrorCollector;
import com.form.language.memory.RuntimeMemory;

public class Multiplication extends BinaryExpression implements Expression {
	
	public Multiplication(Expression left, Expression right, Token tokenInfo) {
		super(left,right, tokenInfo);
	}

	@Override
	public GenericValue<Integer> evaluate(RuntimeMemory mem) {
		return new IntValue(((IntValue)super.left.evaluate(mem)).getValue() * ((IntValue)super.right.evaluate(mem)).getValue());
	}

	@Override
	public Type getType() {
		if(left.getType().isIntType() && right.getType().isIntType()) return new IntType();
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
				Error newError = new Error(tokenInfo, "Expected Int * Int, but found " + leftType + " * " + rightType);
				errors.add(newError);
				return;
			}
			return;
		}
	}
}
