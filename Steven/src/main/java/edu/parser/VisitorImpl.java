package edu.parser;

import edu.parser.nodes.AbstractNode;
import edu.parser.nodes.expression.NotEqual;
import edu.parser.nodes.question.Label;
import edu.parser.nodes.question.Question;
import edu.parser.nodes.question.QuestionType;
import edu.parser.nodes.statement.Statement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 23/02/2015.
 */
public abstract class VisitorImpl implements Visitor {

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
    public AbstractNode visit(edu.parser.nodes.type.Boolean aBoolean) {
        return aBoolean;
    }

    @Override
    public AbstractNode visit(edu.parser.nodes.type.Number number) {
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
}
