package edu.parser.nodes.question;

import edu.parser.Visitor;
import edu.parser.nodes.AbstractNode;
import edu.parser.nodes.expression.Expression;
import edu.parser.nodes.expression.Identifier;
import edu.parser.nodes.statement.Statement;

import java.util.Optional;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Question extends Statement {

    private final Identifier identifier;
    private final QuestionType questionType;
    private final Label label;
    private final Optional<Expression> expression;
    private boolean enabled;

    public Question(Identifier identifier, QuestionType questionType, Label label, boolean enabled, Optional<Expression> expression) {
        this.expression = expression;
        this.identifier = identifier;
        this.questionType = questionType;
        this.label = label;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
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
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (enabled != question.enabled) return false;
        if (expression != null ? !expression.equals(question.expression) : question.expression != null) return false;
        if (!identifier.equals(question.identifier)) return false;
        if (!label.equals(question.label)) return false;
        if (questionType != question.questionType) return false;

        return true;
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
