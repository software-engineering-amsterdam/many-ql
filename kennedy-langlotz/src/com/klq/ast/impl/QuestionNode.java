package com.klq.ast.impl;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;
import com.klq.logic.Type;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionNode extends ANode {

    private String questionID;
    private Type questionType;
    private String text;

    public QuestionNode(){}
    public QuestionNode(String questionID, String questionType, String text) {
        this.questionID = questionID;
        this.questionType = Type.valueOf(questionType.toUpperCase());
        this.text = text;
    }

    @Override
    public void accept(IVisitor visitor) {
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

    public String getQuestionID() {
        return questionID;
    }

    public Type getQuestionType() {
        return questionType;
    }

    public String getText() {
        return text;
    }
}
