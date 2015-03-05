package edu.parser.QL;

import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.NotEqual;
import edu.parser.QL.nodes.question.Label;
import edu.parser.QL.nodes.question.Question;
import edu.parser.nodes.QuestionType;
import edu.parser.QL.nodes.statement.Statement;

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
    public AbstractNode visit(Question question) {
        return question;
    }

    @Override
    public AbstractNode visit(Statement statement) {
        return statement;
    }
}
