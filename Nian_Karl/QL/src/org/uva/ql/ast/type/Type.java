package org.uva.ql.ast.type;

import org.uva.ql.ast.Node;

public abstract class Type implements Node{
	
	public boolean isInt(){
		return false;
	}
	
	public boolean isBool(){
		return false;
	}
	
	public boolean isStr(){
		return false;
	}
	
	public abstract boolean isEqual(Type type);
	
}
