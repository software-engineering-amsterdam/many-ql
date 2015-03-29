package com.form.language.ast.values;

public class UndefinedValue extends GenericValue {

    @Override
    public boolean equals(Object o) {
	return false;
    }

    @Override
    public int hashCode() {
	return 0;
    }

    @Override
    public String toString() {
	return "UNDEFINED";
    }
}
