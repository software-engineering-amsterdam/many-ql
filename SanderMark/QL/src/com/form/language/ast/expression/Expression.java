package com.form.language.ast.expression;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.ASTNode;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.values.GenericValue;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollection;

public abstract class Expression extends ASTNode {
    public abstract GenericValue evaluate(Context context);

    public abstract void collectIds(IdCollection idCollection);
    
    protected Expression(Token tokenInfo) {
	super(tokenInfo);
    }
    
    public Boolean isCorrectlyTyped(Context context) {
	return !this.getType(context).equals(new ErrorType());
    }
}