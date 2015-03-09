package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
//TODO: this is weird, it doesnt inherit unary or binary yet is not in the same level
public abstract class Literal implements Expression {

	public Token tokenInfo;
	public Literal(Token tokenInfo){
		this.tokenInfo = tokenInfo;
	}
	@Override
	public Boolean isCorrectlyTyped(Context mem) {
		return true;
	}
	
	public String showTokenInfo(){
		return "line: " + tokenInfo.getLine() + ", column:" + tokenInfo.getCharPositionInLine();
	}
	
//	@Override
//	public void getErrors(ErrorCollector errorCollector) {
//		return;
//	}
	
	@Override
	public void collectIds(IdCollector idCollector)
	{
		return;		
	}
	@Override
	public void setType(IdTypeTable ids) {}
	@Override
	public void getReferences(IdCollector idCollector) {}
	
	
}
