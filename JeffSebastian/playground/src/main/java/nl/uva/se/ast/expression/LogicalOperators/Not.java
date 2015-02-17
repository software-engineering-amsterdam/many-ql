package nl.uva.se.ast.expression.LogicalOperators;

import nl.uva.se.ast.expression.Expression;
import nl.uva.se.ast.expression.Unary;
import nl.uva.se.visitor.Visitor;

public class Not extends Unary{

	public Not(int lineNumber, int offset, Expression singleExpression) {
		super(lineNumber, offset, singleExpression);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
