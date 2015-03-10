package org.uva.qls.visitor;

import org.uva.qls.ast.QLSNode;

public interface StyleVisitor<T> {
	public T visit(QLSNode node);
}
