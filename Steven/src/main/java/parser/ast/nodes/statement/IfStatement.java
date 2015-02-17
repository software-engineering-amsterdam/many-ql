package parser.ast.nodes.statement;

import parser.ast.nodes.expression.Expression;

import java.util.List;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class IfStatement extends Statement {
    private final Expression expression;
    private final List<Statement> statements;

    public IfStatement(Expression expression, List<Statement> statements) {
        this.expression = expression;
        this.statements = statements;
    }

    public Expression getExpression() {
        return expression;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
