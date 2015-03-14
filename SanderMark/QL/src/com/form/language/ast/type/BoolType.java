package com.form.language.ast.type;

import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.GenericValue;

public final class BoolType extends Type {

    @Override
    public Type getType() {
	return this;
    }

    @Override
    public boolean isBoolType() {
	return true;
    }

    @Override
    public String toString() {
	return "Bool";
    }

    @Override
    public GenericValue defaultValue() {
	// TODO Auto-generated method stub
	return new BoolValue(false);
    }

    @Override
    public boolean equals(Object o) {
	return (o instanceof BoolType);
    }
    
    @Override
    //TODO: this makes sense because there are no fields. But maybe it is some sort of bad smell? We never use different instances of this 'object'
    public int hashCode() {
	return 3;
    }
}
