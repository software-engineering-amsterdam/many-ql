package org.uva.sea.ql.AST.expression;

import org.uva.sea.ql.AST.literal.AbstractLiteral;
import org.uva.sea.ql.AST.visitor.Visitor;

public abstract class DataTypeExpression extends Expression{

	private AbstractLiteral literal;
	
	public DataTypeExpression(AbstractLiteral literal) {
		this.literal = literal;
	}
	
	public AbstractLiteral getLiteral() {
		return literal;
	}
	
	@Override
	public abstract void accept(Visitor visitor);
}
