package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollection;
//TODO: this is weird, it doesnt inherit unary or binary yet is not in the same level
public abstract class Literal implements Expression {

	public Token tokenInfo;
	public Literal(Token tokenInfo){
		this.tokenInfo = tokenInfo;
	}
	@Override
	public Boolean isCorrectlyTyped(Context context) {
		return true;
	}
	
	public String showTokenInfo(){
		return "line: " + tokenInfo.getLine() + ", column:" + tokenInfo.getCharPositionInLine();
	}
	
	@Override
	public void collectIds(IdCollection idCollection)	{}
}
