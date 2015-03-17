package com.form.language.ast.type;

import com.form.language.ast.values.GenericValue;

public final class ErrorType extends Type {

    @Override
    public Type getType() {
	return this;
    }

    @Override
    public boolean isErrorType() {
	return true;
    }

    @Override
    public String toString() {
	return "Error";
    }

    @Override
    public GenericValue defaultValue() {
	return null;
    }
    
    @Override
    public boolean equals(Object o) {
	return (o instanceof ErrorType);
    }
    
    @Override
    //TODO: this makes sense because there are no fields. But maybe it is some sort of bad smell? We never use different instances of this 'object'
    public int hashCode() {
	return 2;
    }
}
