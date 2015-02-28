package edu.parser.QL.nodes.statement;

import edu.parser.QL.Visitor;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.Expression;

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
    public boolean hasBooleanOperands() {
        return false;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
