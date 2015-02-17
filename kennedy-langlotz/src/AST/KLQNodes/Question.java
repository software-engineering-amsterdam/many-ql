package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

import java.util.Arrays;

/**
 * Created by juriaan on 10-2-15.
 */
public class Question extends Node {
    public enum QuestionType{
        SET, BOOLEAN, DATE, CURRENCY, STRING, NUMERAL
    }

    private String questionID;
    private String questionType;
    private String text;

    public Question(){}
    public Question(String questionID, String questionType, String text) {
        this.questionID = questionID;
        this.questionType = questionType;
        this.text = text;
    }

    @Override
    public void accept(Visitor visitor) {
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
        System.out.println(getChildren().size());
        System.out.println();
    }
}
