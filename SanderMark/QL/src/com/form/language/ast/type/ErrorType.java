package com.form.language.ast.type;

import com.form.language.ast.values.GenericValue;

public class ErrorType extends Type {

    @Override
    public Type getType() {
	return this;
    }

    @Override
    public Boolean isErrorType() {
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

}
