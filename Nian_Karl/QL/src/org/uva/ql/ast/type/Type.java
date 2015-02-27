package org.uva.ql.ast.type;

import org.uva.ql.ast.Node;
import org.uva.ql.ast.builder.CodePosition;

public abstract class Type implements Node {
	
	private final CodePosition position;
	
	public CodePosition getPosition() {
		return position;
	}
	
	public Type(CodePosition pos) {
		this.position = pos;
	}
	
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
