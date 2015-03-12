package edu.parser.QL.nodes.statement;

import edu.exceptions.ParseException;
import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.Expression;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class IfStatement extends Statement {
    private final Expression expression;
    private final List<Statement> statements;
    private final Optional<ElseClause> elseClause;

    public IfStatement(Expression expression, List<Statement> statements, Optional<ElseClause> elseClause) {
        this.expression = expression;
        this.statements = statements;
        this.elseClause = elseClause;
    }

    public Optional<ElseClause> getElseClause() {
        return elseClause;
    }

    public Expression getExpression() {
        return expression;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public AbstractNode accept(QLVisitor QLVisitor) {
        return QLVisitor.visit(this);
    }

    @Override
    public IfStatement clone() throws CloneNotSupportedException {
        Expression clonedExpression = expression.clone();
        List<Statement> clonedStatements = cloneStatements();
        Optional<ElseClause> clonedElseClause = cloneElseClause();
        return new IfStatement(clonedExpression, clonedStatements, clonedElseClause);
    }

    private List<Statement> cloneStatements() {
        return statements.stream()
                .map(IfStatement::cloneAndCatchException)
                .collect(Collectors.toList());
    }

    private static Statement cloneAndCatchException(Statement statement) {
        try {
            return statement.clone();
        } catch (CloneNotSupportedException e) {
            throw new ParseException(e);
        }
    }

    private Optional<ElseClause> cloneElseClause() throws CloneNotSupportedException {
        if (elseClause.isPresent()) {
            return Optional.of(elseClause.get().clone());
        } else {
            return Optional.empty();
        }

    }
}
