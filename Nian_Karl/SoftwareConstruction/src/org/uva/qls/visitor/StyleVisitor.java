package org.uva.qls.visitor;

import org.uva.ql.ast.Node;

public interface StyleVisitor<T> {
	public T visit(Node node);
}
