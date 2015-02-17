package AST.KLQNodes;

import AST.*;

/**
 * Created by juriaan on 17-2-15.
 */
public class ComputedQuestion extends Question {

    public ComputedQuestion(String questionID, String questionType, String text) {
        super(questionID, questionType, text);
    }

    @Override
    public void accept(Visitor visitor) {
        for(Node child : this.getChildren()){
            child.accept(visitor);
        }
        visitor.visit(this);
    }

}
