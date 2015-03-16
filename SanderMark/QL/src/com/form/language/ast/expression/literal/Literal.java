package com.form.language.ast.expression.literal;

import com.form.language.ast.expression.Expression;
import com.form.language.error.QLToken;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollection;

//TODO: this is weird, it doesnt inherit unary or binary yet is not in the same level
public abstract class Literal extends Expression {


    public Literal(QLToken tokenInfo) {
	super(tokenInfo);
    }

    @Override
    public Boolean isCorrectlyTyped(Context context) {
	return true;
    }

    @Override
    public void collectIds(IdCollection idCollection) {
    }

}
