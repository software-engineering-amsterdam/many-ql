package com.form.language.ast.type;

import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.StringValue;

public final class StringType extends Type {

    @Override
    public Type getType() {
	return this;
    }

    @Override
    public boolean isStringType() {
	return true;
    }

    @Override
    public String toString() {
	return "String";
    }

    @Override
    public GenericValue defaultValue() {
	// TODO Auto-generated method stub
	return new StringValue("");
    }

    @Override
    public boolean equals(Object o) {
	return (o instanceof StringType);
    }

    @Override
    //TODO: this makes sense because there are no fields. But maybe it is some sort of bad smell? We never use different instances of this 'object'
    public int hashCode() {
	return 0;
    }
    
}
