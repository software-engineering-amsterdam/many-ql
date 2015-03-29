package com.form.language.ast.expression.variable;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.issue.Error;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public class Reference extends Expression {
    private ReferenceName name;

    public Reference(String value, QLToken tokenInfo) {
	super(tokenInfo);
	this.name = new ReferenceName(value);
    }

    public String getName() {
        return name.getValue();
    }

    @Override
    public GenericValue evaluate(Context context) {
	return context.getValue(name.getValue());
    }
    
    @Override
    public Type getType(Context context) {
	return getTypeFromMemory(context);
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
    public void collectIds(ReferenceCollection referenceCollection) {
	referenceCollection.addId(this);
    }

}
