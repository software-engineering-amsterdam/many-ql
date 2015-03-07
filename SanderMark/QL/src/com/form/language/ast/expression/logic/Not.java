package com.form.language.ast.expression.logic;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.error.Error;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.RuntimeMemory;

public class Not extends UnaryExpression implements Expression {

	public Not(Expression value, Token tokenInfo) {
		super(value, tokenInfo);
	}

	@Override
	public BoolValue evaluate(RuntimeMemory mem) {
		return new BoolValue(!((BoolValue)value.evaluate(mem)).getValue());
	}

	@Override
	public Type getType() {
		if(super.value.getType().isBoolType()) return new BoolType();
		return new ErrorType();
	}

	@Override
	public void getErrors(ErrorCollector errors) {
		Type childType = value.getType();
		value.getErrors(errors);
		
		if(childType.isBoolType()) {
			return;
		}
		else{
			if(!childType.isErrorType()){
				Error newError = new Error(tokenInfo, "Expected !Boolean, but found !"  + childType);
				errors.add(newError);
				return;
			}
			return;
		}
	}
}
