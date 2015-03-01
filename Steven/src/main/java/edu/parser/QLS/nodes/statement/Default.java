package edu.parser.QLS.nodes.statement;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;
import edu.parser.QLS.nodes.QuestionType;
import edu.parser.QLS.nodes.styles.Style;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Default extends Statement {
    private final QuestionType questionType;

    public Default(QuestionType questionType, List<Style> style) {
        super(style);
        this.questionType = questionType;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.accept(this);
    }
}
