package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;
import com.form.language.ast.values.StringValue;
import com.form.language.memory.Memory;

public class IdLiteral extends Literal implements Expression {
	private final String _value;
	private Type _type;
	
	public IdLiteral(String value, Token tokenInfo) {
		super(tokenInfo);
		this._value = value;
		System.out.println("test1");
	}
	public IdLiteral(String value, Type questionType,Memory memory,Token tokenInfo)
	{
		super(tokenInfo);
		this._value = value;
		this._type = questionType;	
		System.out.println("test2");
	}

	@Override
	public GenericValue<?> evaluate() {
		if(_type.isBoolType()){
			return new BoolValue(Boolean.parseBoolean(_value));
		};
		if(_type.isIntType()){
			return new IntValue(Integer.parseInt(_value));
		}
		if(_type.isStringType()){
			return new StringValue(_value);
		}
		else 
			throw new IllegalArgumentException();
	}

	@Override
	public Type getType() {
		return _type;
	}
	
	@Override
	public void fillMemory(Memory memory) {
		memory.addId(this);
	}
}
