package com.form.language.ast.expression;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.type.ErrorType;
import com.form.language.memory.Memory;

public abstract class BinaryExpression implements Expression {
	public Token tokenInfo;
	public Expression left;
	public Expression right;
	public BinaryExpression(Expression left, Expression right, Token tokenInfo) {
		this.left = left;
		this.right = right;
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
		left.fillMemory(memory);
		right.fillMemory(memory);
	}
}