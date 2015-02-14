package ast.type;

import ast.IMainVisitable;


public abstract class Type<T> implements IMainVisitable {

	public abstract T accept(ITypeVisitor<T> visitor);
	
	//public abstract String toString();
}
