package edu.parser.QL.nodes.statement;

import edu.exceptions.ParseException;
import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.Expression;

import java.util.List;
import java.util.stream.Collectors;

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
    public AbstractNode accept(QLVisitor QLVisitor) {
        return QLVisitor.visit(this);
    }

    @Override
    public ElseClause clone() throws CloneNotSupportedException {
        List<Statement> clonedStatements = statements.stream()
                .map(ElseClause::cloneAndCatchException)
                .collect(Collectors.toList());
        return new ElseClause(clonedStatements);
    }

    private static Statement cloneAndCatchException(Statement statement) {
        try {
            return statement.clone();
        } catch (CloneNotSupportedException e) {
            throw new ParseException(e);
        }
    }


}
