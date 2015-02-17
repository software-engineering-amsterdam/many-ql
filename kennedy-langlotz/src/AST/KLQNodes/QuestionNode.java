package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionNode extends Node {
    public enum QuestionType{
        SET, BOOLEAN, DATE, CURRENCY, STRING, NUMERAL
    }

    private String questionID;
    private String questionType;
    private String text;
    private boolean computed;

    public QuestionNode(String questionID, String questionType, String text, boolean computed) {
        this.questionID = questionID;
        this.questionType = questionType;
        this.text = text;
        this.computed = computed;
    }

    @Override
    public void accept(Visitor visitor) {
        for(Node child : this.getChildren()){
            child.accept(visitor);
        }
        visitor.visit(this);
    }

    @Override
    public void printSelf(){
        System.out.printf("questionID: %s", questionID);
        System.out.println();
        System.out.printf("type: %s", questionType);
        System.out.println();
        System.out.printf("text: %s", text);
        System.out.println();
    }
}
