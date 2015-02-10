package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionTypeNode extends Node {
    public enum QuestionType{
        SET, BOOLEAN, DATE, CURRENCY, STRING, NUMERAL
    }

    private QuestionType questionType;

    public QuestionTypeNode(QuestionType questionType) {

        this.questionType = questionType;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public QuestionType getQuestionType() {
        return questionType;
    }
}
