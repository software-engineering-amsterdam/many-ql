package com.form.language.ast.type;

public interface TypeVisitor<T> {

	    public T visitBoolType(BoolType btype);
	    public T visitIntType(IntType itype);
	    public T visitStringType(StringType stype);
	    public T visitErrorType(ErrorType etype);
}
