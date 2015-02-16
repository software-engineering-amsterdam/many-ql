package nl.uva.se.ast.statement;

import java.util.List;

import nl.uva.se.ast.Node;
import nl.uva.se.ast.expression.Expression;

public class Condition extends Node<Statement> implements Statement {

	private final Expression expression;

	public Condition(Expression expression, List<Statement> statements) {
		super(statements);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}
	
}
