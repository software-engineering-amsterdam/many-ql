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

    public IntboxWidget(final String questionIdentifier, final QLInterpreter qlInterpreter, final StateWrapper stateWrapper) {
        this.widget = new JTextField((int) Math.log10(Integer.MAX_VALUE - 1) + 1);

        widget.getDocument().addDocumentListener(new DocumentListener() {
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

            public void updateField() {
                VariableTable variableTable = stateWrapper.getVariableTable();
                try {
                    variableTable.setVariable(questionIdentifier, new IntegerValue(Integer.parseInt(widget.getText())));
                } catch(NumberFormatException e) {
                    variableTable.setVariable(questionIdentifier, new IntegerValue(0));
                }
                VariableTable newVariableTable = qlInterpreter.interpret(variableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        });
    }

    @Override
    public Component getWidgetComponent() {
        return widget;
    }

    @Override
    public void resetValue() {
        widget.setText("");
    }
}
