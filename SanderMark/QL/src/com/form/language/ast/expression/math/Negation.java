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
import com.form.language.memory.RuntimeMemory;
import com.form.language.memory.TypeMemory;

public class Negation extends UnaryExpression implements Expression {
	
	public Negation(Expression value, Token tokenInfo) {
		super(value, tokenInfo);
	}

	@Override
	public GenericValue<Integer> evaluate(RuntimeMemory mem) {		
		return new IntValue(-((IntValue)value.evaluate(mem)).getValue());
	}

	@Override
	public Type getType(TypeMemory mem) {
		Type childType = value.getType(mem);
		if(childType.isIntType()){
			return new IntType();
		}
		else{
			if(!childType.isErrorType()){
				mem.addError(new Error(tokenInfo, "Expected -Int, but found -"  + childType));
				}
			return new ErrorType();
		}
	}
	
//	@Override
//	public void getErrors(ErrorCollector errors) {
//		Type childType = value.getType();
//		value.getErrors(errors);
//
//		if(childType.isIntType()) {
//			return;
//		}
//		else{
//			if(!childType.isErrorType()){
//				errors.add(new Error(tokenInfo, "Expected -Int, but found -"  + childType));
//			}
//			return;
//		}
//	}
}
