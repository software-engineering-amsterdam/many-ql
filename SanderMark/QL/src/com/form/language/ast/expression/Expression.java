package com.form.language.ast.expression;

import com.form.language.ast.ASTNode;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollection;

public abstract class Expression extends ASTNode {
    public abstract GenericValue evaluate(Context context);

    public abstract void collectIds(IdCollection idCollection);
    
    protected Expression(QLToken tokenInfo) {
	super(tokenInfo);
    }
    
    public boolean isCorrectlyTyped(Context context) {
	return !this.getType(context).equals(new ErrorType());
    }

    public abstract Type getType(Context context);
}