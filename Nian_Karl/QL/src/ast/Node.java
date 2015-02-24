package ast;

import ast.visitor.Visitor;

public interface Node {
	
	public <T> T accept (Visitor<T> visitor);
	public String toString();
	
}