package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;
import com.form.language.ast.values.StringValue;
import com.form.language.memory.IdCollector;

public class IdLiteral extends Literal implements Expression {
	public final String name;
	private Type type;
	
	public IdLiteral(String value, Token tokenInfo) {
		super(tokenInfo);
		this.name = value;
		System.out.println("test1");
	}
	public IdLiteral(String name, Type questionType,IdCollector idCollector,Token tokenInfo)
	{
		super(tokenInfo);
		this.name = name;
		this.type = questionType;	
		System.out.println("test2");
	}
	
	public Boolean IsReference(){
		if(this.type == null){
			return true;
		}
		return false;
	}

	@Override
	public GenericValue<?> evaluate() {
		if(type.isBoolType()){
			return new BoolValue(Boolean.parseBoolean(name));
		};
		if(type.isIntType()){
			return new IntValue(Integer.parseInt(name));
		}
		if(type.isStringType()){
			return new StringValue(name);
		}
		else 
			throw new IllegalArgumentException();
	}

	@Override
	public Type getType() {
		return type;
	}
	
	@Override
	public void collectIds(IdCollector idCollector) {
		idCollector.addId(this);
	}
}
