package com.form.language.ast.type;

import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.UndefinedValue;

public final class ErrorType extends Type {

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
	return new UndefinedValue();
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
    
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visitErrorType(this);
	}
}
