package com.form.language.ast.expression;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;

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
	public void collectIds(IdCollector idCollector) {
		left.collectIds(idCollector);
		right.collectIds(idCollector);
	}
	
	@Override
	public void setType(IdTypeTable ids) {
		left.setType(ids);
		right.setType(ids);
	}
	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void getErrors(ErrorCollector errorCollector) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public GenericValue<?> evaluate(RuntimeMemory mem) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void getReferences(IdCollector idCollector) {
		left.getReferences(idCollector);
		right.getReferences(idCollector);
	}	
	
}