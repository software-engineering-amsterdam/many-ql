package com.form.language.ast.expression.logic;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.error.Error;
import com.form.language.error.ErrorCollector;

public class Not extends UnaryExpression implements Expression {

	public Not(Expression value, Token tokenInfo) {
		super(value, tokenInfo);
	}

	@Override
	public BoolValue evaluate() {
		return new BoolValue(!((BoolValue)value.evaluate()).getValue());
	}

	@Override
	public Type getType() {
		if(super.value.getType().isBoolType()) return new BoolType();
		return new ErrorType();
	}

	@Override
	public ErrorCollector getErrors(ErrorCollector errors) {
		Type childType = value.getType();
		
		ErrorCollector newErrors = value.getErrors(errors);

		if(childType.isBoolType()) {
			return newErrors;
		}
		else{
			if(!childType.isErrorType()){
				Error newError = new Error(tokenInfo, "Expected !Boolean, but found !"  + childType);
				newErrors.add(newError);
				return newErrors;
			}
			return newErrors;
		}
	}
}
