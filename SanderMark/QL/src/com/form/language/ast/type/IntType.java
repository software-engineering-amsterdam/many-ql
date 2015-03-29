package com.form.language.ast.type;

import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;

public final class IntType extends Type {

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
	return new IntValue(0);
    }
    
    @Override
    //This makes sense because there are no fields. Alternative is making this class a Singleton, but that does make the code less readable
    public boolean equals(Object o) {
	return (o instanceof IntType);
    }
    
    @Override
    public int hashCode() {
	return 1;
    }
}
