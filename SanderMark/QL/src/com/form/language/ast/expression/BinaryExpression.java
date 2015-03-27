package com.form.language.ast.expression;

import com.form.language.ast.expression.variable.ReferenceCollection;
import com.form.language.issue.QLToken;

public abstract class BinaryExpression extends Expression {
    protected Expression left;
    protected Expression right;

    protected BinaryExpression(Expression left, Expression right, QLToken tokenInfo) {
	super(tokenInfo);
	this.left = left;
	this.right = right;
    }

    @Override
    public void collectIds(ReferenceCollection referenceCollection) {
	left.collectIds(referenceCollection);
	right.collectIds(referenceCollection);
    }
}