package com.form.language.ast.expression.math;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;
import com.form.language.error.Error;
import com.form.language.error.ErrorCollector;

public class Negation extends UnaryExpression implements Expression {
	
	public Negation(Expression value, Token tokenInfo) {
		super(value, tokenInfo);
	}

	@Override
	public GenericValue<Integer> evaluate() {		
		return new IntValue(-((IntValue)value.evaluate()).getValue());
	}

	@Override
	public Type getType() {
		if(value.getType().isIntType()) return new IntType();
		return new ErrorType();
	}
	
	@Override
	public ErrorCollector getErrors(ErrorCollector errors) {
		Type childType = value.getType();
		
		ErrorCollector newErrors = value.getErrors(errors);

		if(childType.isIntType()) {
			return newErrors;
		}
		else{
			if(!childType.isErrorType()){
				Error newError = new Error(tokenInfo, "Expected -Int, but found -"  + childType);
				newErrors.add(newError);
				return newErrors;
			}
			return newErrors;
		}
	}
}
