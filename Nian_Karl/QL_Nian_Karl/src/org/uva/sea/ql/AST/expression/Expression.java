package org.uva.sea.ql.AST.expression;

import org.uva.sea.ql.AST.Node;
import org.uva.sea.ql.AST.value.AbstractValue;


public abstract class Expression implements Node{	
	public abstract AbstractValue<?> interpretExpression();
}