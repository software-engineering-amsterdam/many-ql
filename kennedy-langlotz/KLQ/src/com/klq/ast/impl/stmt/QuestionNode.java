package com.klq.ast.impl.stmt;

import com.klq.ast.IStatementVisitor;
import com.klq.ast.impl.Location;
import com.klq.ast.impl.Type;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionNode extends AStatementNode {

    private String questionID;
    private Type questionType;
    private String text;

    public QuestionNode(String questionID, String questionType, String text, Location location) {
        super(location);
        init(questionID, questionType, text);
    }

    public QuestionNode(String questionID, String questionType, String text) {
        super();
        init(questionID, questionType, text);
    }

    private void init(String questionID, String questionType, String text) {
        this.questionID = questionID;
        this.questionType = Type.valueOf(questionType.toUpperCase());
        this.text = text;
    }

    @Override
    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void printSelf(){
        System.out.printf("questionID: %s", questionID);
        System.out.println();
        System.out.printf("type: %s", questionType);
        System.out.println();
        System.out.printf("text: %s", text);
        System.out.println();
    }

    public String getID() {
        return questionID;
    }

    public Type getType() {
        return questionType;
    }

    public String getText() {
        return text;
    }
}
