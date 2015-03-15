package com.form.language.ast.expression;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.type.ErrorType;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollection;

public abstract class UnaryExpression extends Expression {
    protected Expression value;

    protected UnaryExpression(Expression value, Token tokenInfo) {
	super(tokenInfo);
	this.value = value;
    }

    @Override
    public Boolean isCorrectlyTyped(Context mem) {
	return !this.getType(mem).equals(new ErrorType());
    }

    @Override
    public String showTokenInfo() {
	return "line: " + tokenInfo.getLine();
    }

    @Override
    public void collectIds(IdCollection idCollection) {
	value.collectIds(idCollection);
    }
}