package nl.uva.se.ast.expression.arithmetical;

import nl.uva.se.ast.expression.Expression;
import nl.uva.se.ast.expression.Unary;
import nl.uva.se.visitor.Visitor;

public class Negative extends Unary {

	public Negative(int lineNumber, int offset, Expression singleExpression) {
		super(lineNumber, offset, singleExpression);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		getSingleExpression().accept(visitor);
	}

}
