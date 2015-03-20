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
    //This makes sense because there are no fields. Alternative is making this class a Singleton, but that does make the code less readable
    public boolean equals(Object o) {
	return (o instanceof ErrorType);
    }
    
    @Override
    public int hashCode() {
	return 2;
    }
}
