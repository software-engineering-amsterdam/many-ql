package nl.uva.se.ast.expression.LogicalOperators;

import nl.uva.se.ast.expression.Binary;
import nl.uva.se.ast.expression.Expression;
import nl.uva.se.visitor.Visitor;

public class NotEqual extends Binary {

	public NotEqual(int lineNumber, int offset, Expression left,
			Expression right) {
		super(lineNumber, offset, left, right);
	}

	@Override
	public void accept(Visitor visitor) {
	visitor.visit(this);		
	}

}
