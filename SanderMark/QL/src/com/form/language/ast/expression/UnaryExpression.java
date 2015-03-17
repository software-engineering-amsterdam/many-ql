package com.form.language.ast.expression;

import com.form.language.error.QLToken;
import com.form.language.memory.IdCollection;

public abstract class UnaryExpression extends Expression {
    protected Expression value;

    protected UnaryExpression(Expression value, QLToken tokenInfo) {
	super(tokenInfo);
	this.value = value;
    }

    @Override
    public void collectIds(IdCollection idCollection) {
	value.collectIds(idCollection);
    }
}