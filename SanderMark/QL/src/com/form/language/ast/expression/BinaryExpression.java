package com.form.language.ast.expression;

import com.form.language.issue.QLToken;
import com.form.language.memory.IdCollection;

public abstract class BinaryExpression extends Expression {
    protected Expression left;
    protected Expression right;

    protected BinaryExpression(Expression left, Expression right, QLToken tokenInfo) {
	super(tokenInfo);
	this.left = left;
	this.right = right;
    }

    @Override
    public void collectIds(IdCollection idCollection) {
	left.collectIds(idCollection);
	right.collectIds(idCollection);
    }
}