package edu.parser.QL;

import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.*;
import edu.parser.QL.nodes.question.Label;
import edu.parser.QL.nodes.question.QLQuestion;
import edu.parser.QL.nodes.statement.Statement;
import edu.parser.nodes.QuestionType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 23/02/2015.
 */
public abstract class QLVisitorImpl implements QLVisitor {

    public List<Statement> visitStatements(List<Statement> statements) {
        if (statements != null && !statements.isEmpty()) {
            return statements.stream()
                    .map(statement -> (Statement) statement.accept(this))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public AbstractNode visit(NotEqual notEqual) {
        return notEqual;
    }

    @Override
    public AbstractNode visit(edu.parser.QL.nodes.type.Boolean aBoolean) {
        return aBoolean;
    }

    @Override
    public AbstractNode visit(edu.parser.QL.nodes.type.Number number) {
        return number;
    }

    @Override
    public AbstractNode visit(QuestionType questionType) {
        return questionType;
    }

    @Override
    public AbstractNode visit(Label label) {
        return label;
    }

    @Override
    public AbstractNode visit(QLQuestion question) {
        return question;
    }

    @Override
    public AbstractNode visit(Statement statement) {
        return statement;
    }

    @Override
    public AbstractNode visit(Addition addition) {
        return addition;
    }

    @Override
    public AbstractNode visit(And and) {
        return and;
    }

    @Override
    public AbstractNode visit(Equal equal) {
        return equal;
    }

    @Override
    public AbstractNode visit(GreaterOrEqual greaterOrEqual) {
        return greaterOrEqual;
    }

    @Override
    public AbstractNode visit(GreaterThan greaterThan) {
        return greaterThan;
    }

    @Override
    public AbstractNode visit(Identifier identifier) {
        return identifier;
    }

    @Override
    public AbstractNode visit(LessOrEqual lessOrEqual) {
        return lessOrEqual;
    }

    @Override
    public AbstractNode visit(LessThan lessThan) {
        return lessThan;
    }

    @Override
    public AbstractNode visit(Multiplication multiplication) {
        return multiplication;
    }

    @Override
    public AbstractNode visit(Not not) {
        return not;
    }

    @Override
    public AbstractNode visit(Or or) {
        return or;
    }

    @Override
    public AbstractNode visit(Division division) {
        return division;
    }
}
