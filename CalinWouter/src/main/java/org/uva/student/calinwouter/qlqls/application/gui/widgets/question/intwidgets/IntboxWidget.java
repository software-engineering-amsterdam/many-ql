package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.StateWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class IntboxWidget implements IWidget {
    private JTextField widget;
    private final String questionIdentifier;
    private final QLInterpreter qlInterpreter;
    private final StateWrapper stateWrapper;
    private final static Integer MAX_TEXTBOX_LENGTH_FOR_INTEGER = (int) Math.log10(Integer.MAX_VALUE - 1) + 1;

    @Override
    public Component getWidgetComponent() {
        return widget;
    }

    @Override
    public void resetValue() {
        widget.setText("");
    }

    private void resetVariable(VariableTable variableTable) {
        variableTable.setVariable(questionIdentifier, new IntegerValue(0));
    }

    private void trySetVariable(VariableTable variableTable) {
        try {
            final Integer newValue = Integer.parseInt(widget.getText());
            final IntegerValue integerValue = new IntegerValue(newValue);
            variableTable.setVariable(questionIdentifier, integerValue);
        } catch(NumberFormatException e) {
            resetVariable(variableTable);
        }
    }

    private DocumentListener createIntboxChangeListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateField();
            }

            private void updateField() {
                VariableTable variableTable = stateWrapper.getVariableTable();
                trySetVariable(variableTable);
                VariableTable newVariableTable = qlInterpreter.interpret(variableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        };
    }

    public IntboxWidget(String questionIdentifier, QLInterpreter qlInterpreter, StateWrapper stateWrapper) {
        this.questionIdentifier = questionIdentifier;
        this.qlInterpreter = qlInterpreter;
        this.stateWrapper = stateWrapper;
        this.widget = new JTextField(MAX_TEXTBOX_LENGTH_FOR_INTEGER);
        widget.getDocument().addDocumentListener(createIntboxChangeListener());
    }
}
