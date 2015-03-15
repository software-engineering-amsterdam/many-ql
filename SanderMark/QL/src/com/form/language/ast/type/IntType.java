package com.form.language.ast.type;

import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;

public final class IntType extends Type {

    @Override
    public Type getType() {
	return this;
    }

    @Override
    public boolean isIntType() {
	return true;
    }

    @Override
    public String toString() {
	return "Int";
    }

    @Override
    public GenericValue defaultValue() {
	// TODO Auto-generated method stub
	return new IntValue(0);
    }
    
    @Override
    public boolean equals(Object o) {
	return (o instanceof IntType);
    }
    
    @Override
    //TODO: this makes sense because there are no fields. But maybe it is some sort of bad smell? We never use different instances of this 'object'
    public int hashCode() {
	return 1;
    }
}
