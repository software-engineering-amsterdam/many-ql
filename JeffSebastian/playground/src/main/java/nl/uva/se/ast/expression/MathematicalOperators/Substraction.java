package nl.uva.se.ast.expression.MathematicalOperators;

import nl.uva.se.ast.expression.Expression;
import nl.uva.se.ast.expression.Unary;
import nl.uva.se.visitor.Visitor;

public class Substraction extends Unary{

	public Substraction(int lineNumber, int offset, Expression singleExpression) {
		super(lineNumber, offset, singleExpression);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
	visitor.visit(this);
	}
	

}
