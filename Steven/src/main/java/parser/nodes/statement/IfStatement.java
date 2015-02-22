package parser.nodes.statement;

import parser.Visitor;
import parser.nodes.AbstractNode;
import parser.nodes.expression.Expression;

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

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
