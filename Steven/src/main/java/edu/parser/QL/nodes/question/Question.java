package edu.parser.QL.nodes.question;

import edu.gui.components.store.Store;
import edu.nodes.QuestionType;
import edu.nodes.styles.Style;
import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.Expression;
import edu.parser.QL.nodes.expression.QLIdentifier;
import edu.parser.QL.nodes.statement.Statement;

import java.util.List;
import java.util.Optional;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Question extends Statement {

    private final QLIdentifier QLIdentifier;
    private final QuestionType questionType;
    private final Label label;
    private final Optional<Expression> expression;
    private boolean isEnabled; //todo should receive enum State (enabled/disables/unselected/non-boolean)
    private List<Style> styles;
    private Store value;

    public Question(QLIdentifier QLIdentifier, QuestionType questionType, Label label, boolean isEnabled, Optional<Expression> expression, List<Style> styles, Store value) {
        this.expression = expression;
        this.QLIdentifier = QLIdentifier;
        this.questionType = questionType;
        this.label = label;
        this.isEnabled = isEnabled;
        this.styles = styles;
        this.value = value;
    }

    public Store getValue() {
        return value;
    }

    public void setState(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void setValue(Store value) {
        this.value = value;
    }

    public boolean isEnabled() { //todo: refactor to: getState
        return isEnabled;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
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
    public String toString() {
        return "Question{" +
                "identifier=" + QLIdentifier +
                '}';
    }
}
