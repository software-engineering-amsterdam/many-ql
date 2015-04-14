package com.form.language.ast.type;

import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.GenericValue;

public final class BoolType extends Type {

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
	return new BoolValue(false);
    }

    @Override
    //This makes sense because there are no fields. Alternative is making this class a Singleton, but that does make the code less readable
    public boolean equals(Object o) {
	return (o instanceof BoolType);
    }
    
    @Override
    public int hashCode() {
	return 3;
    }
    
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visitBoolType(this);
	}
}
