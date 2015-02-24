package org.uva.sea.ql.AST.literal;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.Visitable;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.value.AbstractValue;
import org.uva.sea.ql.AST.visitor.Visitor;

public abstract class AbstractLiteral extends Expression{ 
	
	@Override
	public abstract void accept(Visitor visitor);
}
