package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class TextboxWidget implements IWidget {
    private JTextField widget;

    public TextboxWidget(final String questionIdentifier, final QLInterpreter qlIntepreter, final VariableTableWrapper variableTableWrapper) {
        this.widget = new JTextField(20);
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
                VariableTable variableTable = variableTableWrapper.getVariableTable();
                variableTable.setVariable(questionIdentifier, new StringValue(widget.getText()));
                VariableTable newVariableTable = qlIntepreter.interpret(variableTable);
                variableTableWrapper.setVariableTable(newVariableTable);
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
