package org.uva.sea.ql.AST;

import org.uva.sea.ql.AST.value.AbstractValue;

public interface Visitor {

	public AbstractValue visit(Node node);
	
}
