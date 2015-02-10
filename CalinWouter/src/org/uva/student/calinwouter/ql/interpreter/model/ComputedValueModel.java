package org.uva.student.calinwouter.ql.interpreter.model;

public class ComputedValueModel implements DisplayModelInterface {
    private final String variable;
    private final String text;
    private final String type;
    private final Object value;

    public String getVariable() {
        return variable;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public ComputedValueModel(String variable, String text, String type, Object value) {
        this.variable = variable;
        this.text = text;
        this.type = type;
        this.value = value;
    }

}