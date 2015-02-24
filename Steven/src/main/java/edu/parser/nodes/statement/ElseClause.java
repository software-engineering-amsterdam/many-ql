package edu.parser.nodes.statement;

import edu.parser.Visitor;
import edu.parser.nodes.AbstractNode;
import edu.parser.nodes.expression.Expression;

import java.util.List;

/**
 * Created by Steven Kok on 23/02/2015.
 */
public class ElseClause extends Expression {

    private final List<Statement> statements;

    public ElseClause(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public boolean isConditional() {
        return false;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
