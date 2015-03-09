package com.form.language.ast.expression;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.type.ErrorType;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;

public abstract class UnaryExpression implements Expression{
	public Token tokenInfo;
	public Expression value;
	public UnaryExpression(Expression value, Token tokenInfo) {
		this.value = value;
		this.tokenInfo = tokenInfo;
	}
	
	@Override
	public Boolean isCorrectlyTyped(Context mem) {
		return !this.getType(mem).equals(new ErrorType());
	}
	
	@Override
	public String showTokenInfo(){
		return "line: " + tokenInfo.getLine();
	}
	@Override
	public void collectIds(IdCollector idCollector) {
		value.collectIds(idCollector);
	}

	@Override
	public void setType(IdTypeTable ids) {
		value.setType(ids);
	}

	@Override
	public void getReferences(IdCollector idCollector) {
		this.value.getReferences(idCollector);	
	}
	
}