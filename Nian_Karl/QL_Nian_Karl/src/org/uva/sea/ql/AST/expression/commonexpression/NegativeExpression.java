package org.uva.sea.ql.AST.expression.commonexpression;

import org.uva.sea.ql.AST.expression.DataTypeExpression;
import org.uva.sea.ql.AST.literal.AbstractLiteral;
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.value.IntegerValue;
import org.uva.sea.ql.AST.visitor.Visitor;

public class NegativeExpression extends DataTypeExpression{

	private NumberLiteral numberLiteral;
	public NegativeExpression(AbstractLiteral literal) {
		super(literal);
		numberLiteral = (NumberLiteral) literal;

	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
