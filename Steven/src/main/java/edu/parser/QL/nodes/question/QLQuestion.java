package edu.parser.QL.nodes.question;

import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.Expression;
import edu.parser.QL.nodes.expression.Identifier;
import edu.parser.QL.nodes.statement.Statement;
import edu.parser.nodes.QuestionType;

import java.util.Optional;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class QLQuestion extends Statement {

    private final Identifier identifier;
    private final QuestionType questionType;
    private final Label label;
    private final Optional<Expression> expression;
    private final boolean enabled; //todo should receive enum State (enabled/disables/unselected/non-boolean)

    public QLQuestion(Identifier identifier, QuestionType questionType, Label label, boolean enabled, Optional<Expression> expression) {
        this.expression = expression;
        this.identifier = identifier;
        this.questionType = questionType;
        this.label = label;
        this.enabled = enabled;
    }

    public boolean isEnabled() { //todo: refactor to: getState
        return enabled;
    }

    public QLQuestion enable() {
        return new QLQuestion(identifier, questionType, label, true, expression);
    }

    public QLQuestion disable() {
        return new QLQuestion(identifier, questionType, label, false, expression);
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public Label getLabel() {
        return label;
    }

    public Optional<Expression> getExpression() {
        return expression;
    }

    @Override
    public AbstractNode accept(QLVisitor QLVisitor) {
        return QLVisitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QLQuestion question = (QLQuestion) o;

        if (enabled != question.enabled) return false;
        // intellij 'simplified' the next line:
        return !(expression != null ? !expression.equals(question.expression) : question.expression != null) && identifier.equals(question.identifier) && label.equals(question.label) && questionType == question.questionType;

    }

    @Override
    public int hashCode() {
        int result = identifier.hashCode();
        result = 31 * result + questionType.hashCode();
        result = 31 * result + label.hashCode();
        result = 31 * result + (expression != null ? expression.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }
}
