package nl.uva.se.ast.expression.logical;

import nl.uva.se.ast.expression.Expression;
import nl.uva.se.ast.expression.Unary;
import nl.uva.se.visitor.Visitor;

public class Not extends Unary{

	public Not(int lineNumber, int offset, Expression singleExpression) {
		super(lineNumber, offset, singleExpression);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
