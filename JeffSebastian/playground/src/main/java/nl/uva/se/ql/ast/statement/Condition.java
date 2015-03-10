package nl.uva.se.ql.ast.statement;

import java.util.List;

import nl.uva.se.ql.ast.expression.Expression;

public class Condition extends Statement {

	private final Expression expression;
	private final List<Statement> statements;

	public Condition(int lineNumber, int offset, Expression expression,
			List<Statement> statements) {
		super(lineNumber, offset);
		this.expression = expression;
		this.statements = statements;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	public List<Statement> getStatements() {
		return statements;
	}
	
	public void visitChildren(StatementVisitor visitor) {
		for (Statement statement : statements) {
			statement.accept(visitor);
		}
	}
	
}
