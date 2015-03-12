package edu.parser

import edu.nodes.QuestionType
import edu.nodes.styles.Style
import edu.parser.QL.nodes.expression.Expression
import edu.parser.QL.nodes.expression.Identifier
import edu.parser.QL.nodes.question.Label
import edu.parser.QL.nodes.question.Question

/**
 * Created by Steven Kok on 10/03/2015.
 */
public class QuestionBuilder {
    private boolean isEnabled
    private Identifier identifier
    private QuestionType questionType
    private Label label
    private Optional<Expression> expression
    private List<Style> styles

    QuestionBuilder() {
        this.isEnabled = false
        this.identifier = new Identifier("identifier")
        this.questionType = QuestionType.BOOLEAN
        this.label = new Label("label")
        this.expression = Optional.empty()
        this.styles = Collections.emptyList()
    }

    public QuestionBuilder isEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this
    }

    public QuestionBuilder identifier(String identifier) {
        this.identifier = new Identifier(identifier)
        return this
    }

    public QuestionBuilder questionType(QuestionType questionType) {
        this.questionType = questionType
        return this
    }

    public QuestionBuilder label(String label) {
        this.label = new Label(label)
        return this
    }

    public QuestionBuilder expression(Optional<Expression> expression) {
        this.expression = expression
        return this
    }

    public QuestionBuilder styles(List<Style> styles) {
        this.styles = styles;
        return this
    }

    public Question build() {
        return new Question(identifier, questionType, label, isEnabled, expression, styles)
    }
}
