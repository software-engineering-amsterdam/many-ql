package com.form.language.ast.expression;

import org.antlr.v4.runtime.Token;

import com.form.language.memory.IdCollection;

public abstract class BinaryExpression extends Expression {
    protected Expression left;
    protected Expression right;

    protected BinaryExpression(Expression left, Expression right, Token tokenInfo) {
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