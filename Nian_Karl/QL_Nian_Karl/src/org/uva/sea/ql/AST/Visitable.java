package org.uva.sea.ql.AST;

import org.uva.sea.ql.AST.visitor.Visitor;

public interface Visitable {
	public void accept(Visitor visitor);
}
