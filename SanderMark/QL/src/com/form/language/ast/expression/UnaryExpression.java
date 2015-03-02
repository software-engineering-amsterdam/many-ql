package com.form.language.ast.expression;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.type.ErrorType;
import com.form.language.memory.Memory;

public abstract class UnaryExpression implements Expression{
	public Token tokenInfo;
	public Expression value;
	public UnaryExpression(Expression value, Token tokenInfo) {
		this.value = value;
		this.tokenInfo = tokenInfo;
	}
	
	@Override
	public Boolean isCorrectlyTyped() {
		return !this.getType().equals(new ErrorType());
	}
	
	@Override
	public String showTokenInfo(){
		return "line: " + tokenInfo.getLine();
	}
	@Override
	public void fillMemory(Memory memory) {
		value.fillMemory(memory);
	}
}