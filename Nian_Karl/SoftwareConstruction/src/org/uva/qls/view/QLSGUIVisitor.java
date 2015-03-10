package org.uva.qls.view;

import org.uva.qls.ast.QLSNode;
import org.uva.qls.visitor.StyleVisitor;

public class QLSGUIVisitor implements StyleVisitor<Void> {

	@Override
	public Void visit(QLSNode node) {
		return null;
	}

}
