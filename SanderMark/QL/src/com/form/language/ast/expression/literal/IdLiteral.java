package com.form.language.ast.expression.literal;

import javax.lang.model.type.UnknownTypeException;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;
import com.form.language.ast.values.StringValue;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;

public class IdLiteral extends Literal implements Expression {
	public final String name;
	private Type type;
	
	public IdLiteral(String value, Token tokenInfo) {
		super(tokenInfo);
		this.name = value;
	}
	public IdLiteral(String name, Type questionType,IdCollector idCollector,Token tokenInfo)
	{
		super(tokenInfo);
		this.name = name;
		this.type = questionType;	
	}
	
	public Boolean IsReference(){
		if(this.type == null){
			return true;
		}
		return false;
	}

	@Override
	public GenericValue<?> evaluate(RuntimeMemory mem) {
		return mem.getValue(name);
	}
	
	public Type getType(){
		if(this.type == null){
			return new ErrorType();
		}
		return this.type;
	}

	@Override
	public void setType(IdTypeTable ids) {
		if(this.type == null){
			this.type = ids.getType(this.name);
		}
	}
	
	@Override
	public void collectIds(IdCollector idCollector) {
		idCollector.addId(this);
	}
}
