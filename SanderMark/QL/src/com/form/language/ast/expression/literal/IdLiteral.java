package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.error.Error;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;

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
	public GenericValue<?> evaluate(Context mem) {
		return mem.getValue(name);
	}
	
	public Type getType(Context mem){
		if(this.IsReference()){
			return getTypeFromMemory(mem);
		}
		mem.addId(this);
		return this.type;
	}
	
	private Type getTypeFromMemory(Context mem) {
		Type typeFromMemory = mem.getIdType(this);
		if(typeFromMemory == null){
			mem.addError(new Error(this.tokenInfo, "Undeclared variable reference"));
			return new ErrorType();
		}
		else return typeFromMemory;
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
	
	@Override
	public void getReferences(IdCollector idCollector) {
		idCollector.addId(this);
	}
	
	
}
