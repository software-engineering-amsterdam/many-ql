package nl.uva.se.ast.statement;

import nl.uva.se.ast.expression.Expression;
import nl.uva.se.visitor.Visitor;

public class Condition extends Statement {

	private final Expression expression;

	public Condition(int lineNumber, int offset, Expression expression) {
		super(lineNumber, offset);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
