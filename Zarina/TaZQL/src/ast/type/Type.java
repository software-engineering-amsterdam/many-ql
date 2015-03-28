package ast.type;

import ast.AST;


public abstract class Type extends AST {
	
	public abstract <T> T accept(ITypeVisitor<T> visitor);
	public abstract String toString();
	
	public abstract boolean isCompatibleToType(Type type);
			
	public boolean isCompatibleToBoolean() {
		return false;
	}
		
	public boolean isCompatibleToString() {
		return false;
	}
		
	public boolean isCompatibleToInteger() {
		return false;
	}
}