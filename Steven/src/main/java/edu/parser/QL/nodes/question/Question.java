package edu.parser.QL.nodes.question;

import edu.nodes.QuestionType;
import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.Expression;
import edu.parser.QL.nodes.expression.Identifier;
import edu.parser.QL.nodes.statement.Statement;

import java.util.Optional;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Question extends Statement implements Cloneable {

    private final Identifier identifier;
    private final QuestionType questionType;
    private final Label label;
    private final Optional<Expression> expression;
    private final boolean isEnabled; //todo should receive enum State (enabled/disables/unselected/non-boolean)

    public Question(Identifier identifier, QuestionType questionType, Label label, boolean isEnabled, Optional<Expression> expression) {
        this.expression = expression;
        this.identifier = identifier;
        this.questionType = questionType;
        this.label = label;
        this.isEnabled = isEnabled;
    }

    public boolean isEnabled() { //todo: refactor to: getState
        return isEnabled;
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
        Question question = (Question) o;
        if (isEnabled != question.isEnabled) return false;
        // intellij 'simplified' the next line:
        return !(expression != null ? !expression.equals(question.expression) : question.expression != null) && identifier.equals(question.identifier) && label.equals(question.label) && questionType == question.questionType;
    }

    @Override
    public int hashCode() {
        int result = identifier.hashCode();
        result = 31 * result + questionType.hashCode();
        result = 31 * result + label.hashCode();
        result = 31 * result + (expression != null ? expression.hashCode() : 0);
        result = 31 * result + (isEnabled ? 1 : 0);
        return result;
    }

    @Override
    public Question clone() throws CloneNotSupportedException {
        return clone(isEnabled);
    }

    public Question clone(boolean isEnabled) throws CloneNotSupportedException {
        Optional<Expression> expression = Optional.empty();
        if (this.expression.isPresent()) {
            expression.of(this.expression.get().clone());
        }

        return new Question(identifier.clone(), questionType, label.clone(), isEnabled, expression);
    }
}
