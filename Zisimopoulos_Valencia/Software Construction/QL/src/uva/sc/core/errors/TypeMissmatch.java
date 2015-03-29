package uva.sc.core.errors;

import uva.sc.core.types.Type;

public class TypeMissmatch implements IError {

    private Type type1;
    private Type type2;

    public TypeMissmatch(Type type1, Type type2) {
	this.type1 = type1;
	this.type2 = type2;
    }

    public String toString() {
	return "Type missmatch cannot convert from " + type1.toString()
		+ " to " + type2.toString();
    }
}
