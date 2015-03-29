package com.form.language.ast.expression;

import com.form.language.ast.expression.variable.ReferenceCollection;
import com.form.language.issue.QLToken;

public abstract class UnaryExpression extends Expression {
    protected Expression value;

    protected UnaryExpression(Expression value, QLToken tokenInfo) {
	super(tokenInfo);
	this.value = value;
    }

    @Override
    public void collectIds(ReferenceCollection referenceCollection) {
	value.collectIds(referenceCollection);
    }
}