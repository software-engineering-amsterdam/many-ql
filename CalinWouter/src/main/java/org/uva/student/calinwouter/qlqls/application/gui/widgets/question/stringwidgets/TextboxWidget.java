package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets;

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

    public TextboxWidget(final String questionIdentifier, final QLInterpreter qlIntepreter, final VariableTable variableTable) {
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
                variableTable.setVariable(questionIdentifier, new StringValue(widget.getText()));
                qlIntepreter.interpret(variableTable);
            }
        });
    }

    @Override
    public Component getWidgetComponent() {
        return widget;
    }
}
