package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.IdType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.GenericValue;
import com.form.language.memory.Memory;

public class IdLiteral extends Literal implements Expression {
	private final String _value;
	private Type _type;
	
	public IdLiteral(String value, Token tokenInfo) {
		super(tokenInfo);
		this._value = value;
		
		//Throw in memory
	}
	public IdLiteral(String value, Type type, Token tokenInfo)
	{
		super(tokenInfo);
		this._value = value;
		this._type = type;	
		
		//Throw in memory
		Memory.addId(_value,_type);
	}

	@Override
	public GenericValue<?> evaluate() {
		return null;
	}

	@Override
	public Type getType() {
		return new IdType();
	}
	@Override
	public Boolean isCorrectlyTyped() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String showTokenInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
