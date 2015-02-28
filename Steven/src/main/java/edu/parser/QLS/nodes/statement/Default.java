package edu.parser.QLS.nodes.statement;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;
import edu.parser.QLS.nodes.QuestionType;
import edu.parser.QLS.nodes.Style;

import java.util.Optional;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Default extends Statement {
    private final QuestionType questionType;

    protected Default(QuestionType questionType, Optional<Style> style) {
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
