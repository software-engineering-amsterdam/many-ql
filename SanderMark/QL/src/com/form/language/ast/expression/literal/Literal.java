package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;

public abstract class Literal implements Expression {

	public Token tokenInfo;
	public Literal(Token tokenInfo){
		this.tokenInfo = tokenInfo;
	}
	@Override
	public Boolean isCorrectlyTyped() {
		return true;
	}
	
	public String showTokenInfo(){
		return "line: " + tokenInfo.getLine() + ", column:" + tokenInfo.getCharPositionInLine();
	}

}
