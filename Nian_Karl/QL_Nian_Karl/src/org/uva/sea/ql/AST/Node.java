package org.uva.sea.ql.AST;

import org.uva.sea.ql.AST.visitor.Visitor;

public abstract class Node {
	public abstract void accept(Visitor visitor);
}
