package uva.sc.core.errors;

import uva.sc.core.types.Type;

public class TypeMissmatch implements IError {

    Type type1;
    Type type2;

    public TypeMissmatch(Type t1, Type t2) {
	type1 = t1;
	type2 = t2;
    }

    public String toString() {
	return "Type missmatch cannot convert from " + type1.toString()
		+ " to " + type2.toString();
    }
}
