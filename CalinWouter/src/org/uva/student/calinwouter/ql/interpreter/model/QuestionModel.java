package org.uva.student.calinwouter.ql.interpreter.model;

public class QuestionModel {

    private final String variable;
    private final String text;
    private final String type;

    public String getVariable() {
        return variable;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public QuestionModel(String variable, String text, String type) {
        this.variable = variable;
        this.text = text;
        this.type = type;
    }

}
