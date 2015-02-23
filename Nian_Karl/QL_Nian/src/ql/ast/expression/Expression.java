package ql.ast.expression;

import ql.ast.ASTNode;

public abstract class Expression implements ASTNode {
	
	//public abstract <T> T accept(Visitor<Value<?>> visitor);
	public abstract String toString();
}
