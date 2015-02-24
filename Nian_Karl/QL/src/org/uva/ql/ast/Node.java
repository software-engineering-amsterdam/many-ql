package org.uva.ql.ast;

import org.uva.ql.ast.visitor.Visitor;

public interface Node {
	
	public <T> T accept (Visitor<T> visitor);
	public String toString();
	
}