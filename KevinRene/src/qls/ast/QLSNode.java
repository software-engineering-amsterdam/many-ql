package qls.ast;

import qls.ast.visitor.Visitor;

public interface QLSNode {
	@Override
	public String toString();
	
	public <T> T accept(Visitor<T> visitor);
}
