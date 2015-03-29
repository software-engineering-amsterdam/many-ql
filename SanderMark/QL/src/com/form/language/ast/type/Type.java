package com.form.language.ast.type;

import com.form.language.ast.values.GenericValue;

public abstract class Type {

    public boolean isBoolType() {
	return false;
    }

    public boolean isErrorType() {
	return false;
    }

    public boolean isStringType() {
	return false;
    }

    public boolean isIntType() {
	return false;
    }

    public abstract GenericValue defaultValue();
    
    
    @Override
    public abstract boolean equals(Object o);
    
    @Override
    public abstract int hashCode();
}
