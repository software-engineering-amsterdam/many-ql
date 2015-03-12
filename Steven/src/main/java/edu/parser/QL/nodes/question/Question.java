package edu.parser.QL.nodes.question;

import edu.exceptions.ParseException;
import edu.nodes.QuestionType;
import edu.nodes.styles.Style;
import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.Expression;
import edu.parser.QL.nodes.expression.QLIdentifier;
import edu.parser.QL.nodes.statement.Statement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Question extends Statement implements Cloneable {

    private final QLIdentifier QLIdentifier;
    private final QuestionType questionType;
    private final Label label;
    private final Optional<Expression> expression;
    private final boolean isEnabled; //todo should receive enum State (enabled/disables/unselected/non-boolean)
    private final List<Style> styles;

    public Question(QLIdentifier QLIdentifier, QuestionType questionType, Label label, boolean isEnabled, Optional<Expression> expression, List<Style> styles) {
        this.expression = expression;
        this.QLIdentifier = QLIdentifier;
        this.questionType = questionType;
        this.label = label;
        this.isEnabled = isEnabled;
        this.styles = styles;
    }

    public boolean isEnabled() { //todo: refactor to: getState
        return isEnabled;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public QLIdentifier getQLIdentifier() {
        return QLIdentifier;
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

        return QLIdentifier.equals(question.QLIdentifier);
    }

    @Override
    public int hashCode() {
        return QLIdentifier.hashCode();
    }

    @Override
    public Question clone() throws CloneNotSupportedException {
        return clone(isEnabled);
    }

    public Question clone(boolean isEnabled) throws CloneNotSupportedException {
        Optional<Expression> clonedExpression = cloneExpression();
        List<Style> clonedStyles = cloneStyles();
        return new Question(QLIdentifier.clone(), questionType, label.clone(), isEnabled, clonedExpression, clonedStyles);
    }

    public Question clone(List<Style> styles) throws CloneNotSupportedException {
        Optional<Expression> clonedExpression = cloneExpression();
        return new Question(QLIdentifier.clone(), questionType, label.clone(), isEnabled, clonedExpression, styles);
    }

    private List<Style> cloneStyles() {
        return styles.stream()
                .map(this::cloneStyle)
                .collect(Collectors.toList());
    }

    private Style cloneStyle(Style style) {
        try {
            return style.clone();
        } catch (CloneNotSupportedException e) {
            throw new ParseException(e);
        }
    }

    private Optional<Expression> cloneExpression() throws CloneNotSupportedException {
        Optional<Expression> expression = Optional.empty();
        if (this.expression.isPresent()) {
            Optional.of(this.expression.get().clone());
        }
        return expression;
    }

    @Override
    public String toString() {
        return "Question{" +
                "identifier=" + QLIdentifier +
                '}';
    }
}
