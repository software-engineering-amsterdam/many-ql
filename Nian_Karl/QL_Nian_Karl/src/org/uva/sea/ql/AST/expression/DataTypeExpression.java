package org.uva.sea.ql.AST.expression;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.Node;
import org.uva.sea.ql.AST.literal.AbstractLiteral;
import org.uva.sea.ql.AST.value.AbstractValue;

public abstract class DataTypeExpression extends Expression{

	private AbstractLiteral literal;
	
	public DataTypeExpression(AbstractLiteral literal) {
		this.literal = literal;
	}
	
	@Override
	public abstract AbstractValue<?> interpretExpression();
	
	public AbstractLiteral getLiteral() {
		return literal;
	}
	
	@Override
	public List<Node> visit() {
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(literal);
		return nodes;
	}
}
