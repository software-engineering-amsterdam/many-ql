package com.form.language.ast.expression.literal;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.variable.ReferenceCollection;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public abstract class Literal extends Expression {

    public Literal(QLToken tokenInfo) {
	super(tokenInfo);
    }

    @Override
    public boolean isCorrectlyTyped(Context context) {
	return true;
    }

    @Override
    public void collectIds(ReferenceCollection referenceCollection) {
    }

}
