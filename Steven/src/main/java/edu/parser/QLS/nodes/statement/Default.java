package edu.parser.QLS.nodes.statement;

import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.nodes.styles.Style;
import edu.parser.nodes.QuestionType;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Default extends Statement {
    private final QuestionType questionType;
    private final List<Style> styles;

    public Default(QuestionType questionType, List<Style> styles) {
        this.styles = styles;
        this.questionType = questionType;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
