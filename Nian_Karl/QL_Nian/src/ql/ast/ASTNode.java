package ql.ast;

import ql.ast.visitor.Visitor;

public interface ASTNode {
	
	public <T> T accept(Visitor<T> visitor);
}
