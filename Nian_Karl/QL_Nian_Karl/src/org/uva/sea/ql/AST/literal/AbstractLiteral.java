package org.uva.sea.ql.AST.literal;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.Node;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.value.AbstractValue;
import org.uva.sea.ql.AST.visitor.Visitor;

public abstract class AbstractLiteral extends Expression{ 
	@Override
	public abstract AbstractValue<?> interpretExpression();
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
