package com.form.language.ast.expression;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.type.ErrorType;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollection;

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
	public Boolean isCorrectlyTyped(Context context) {
		return !this.getType(context).equals(new ErrorType());
	}
	
	@Override
	public String showTokenInfo(){
		return "line: " + tokenInfo.getLine();
	}	
	
	@Override
	public void collectIds(IdCollection idCollection) {
		left.collectIds(idCollection);
		right.collectIds(idCollection);
	}
}