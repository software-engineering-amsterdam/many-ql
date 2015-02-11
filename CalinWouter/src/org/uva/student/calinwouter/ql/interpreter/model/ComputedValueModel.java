package org.uva.student.calinwouter.ql.interpreter.model;

import javax.swing.event.TableModelEvent;

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

    @Override
    public Object[] renderTableRow(Environment environment) {
        return new Object[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean updateEnvironmentForRowChange(TableModelEvent e) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}