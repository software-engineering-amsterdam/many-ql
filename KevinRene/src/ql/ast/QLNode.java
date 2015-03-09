package ql.ast;

import ql.ast.visitor.Visitor;

public interface QLNode {
	@Override
	public String toString();
	
	public <T> T accept(Visitor<T> visitor);
}
