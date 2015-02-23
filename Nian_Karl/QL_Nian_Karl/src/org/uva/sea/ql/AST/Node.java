package org.uva.sea.ql.AST;


public interface Node {
	public <T> T accept(Visitor<T> visitor);
}
