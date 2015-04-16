package com.form.language.ast.type;

import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.StringValue;

public final class StringType extends Type {

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
	return new StringValue("");
    }

    @Override
    //This makes sense because there are no fields. Alternative is making this class a Singleton, but that does make the code less readable
    public boolean equals(Object o) {
	return (o instanceof StringType);
    }

    @Override
    public int hashCode() {
	return 0;
    }
    
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visitStringType(this);
	}
    
}
