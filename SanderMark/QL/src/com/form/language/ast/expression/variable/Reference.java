package com.form.language.ast.expression.variable;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.error.Error;
import com.form.language.error.QLToken;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollection;

public class Reference extends Expression {
    private String name;
    private Type type;

    public Reference(String value, QLToken tokenInfo) {
	super(tokenInfo);
	this.name = value;
    }

    public Reference(String name, Type questionType, IdCollection idCollection, QLToken tokenInfo) {
	super(tokenInfo);
	this.name = name;
	this.type = questionType;
    }

    public String getName() {
        return name;
    }

    public Boolean IsReference() {
	return (this.type == null);
    }

    @Override
    public GenericValue evaluate(Context context) {
	return context.getValue(name);
    }
    
    @Override
    public Type getType(Context context) {
	if (this.IsReference()) {
	    return getTypeFromMemory(context);
	}
	context.addId(this);
	return this.type;
    }

    private Type getTypeFromMemory(Context context) {
	Type typeFromMemory = context.getIdType(this);
	if (typeFromMemory == null) {
	    context.addError(new Error(tokenInfo, "Undeclared variable reference"));
	    return new ErrorType();
	} else {
	    return typeFromMemory;
	}
    }

    @Override
    public void collectIds(IdCollection idCollection) {
	idCollection.addId(this);
    }

}
