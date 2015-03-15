package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class TextboxWidget implements IWidget {
    private JTextField widget;

    public TextboxWidget(final Question question, final QLInterpreter qlIntepreter, final VariableTable symbolTable) {
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
                symbolTable.setVariable(question.getIdent(), new StringValue(widget.getText()));
                qlIntepreter.interpret();
            }
        });
    }

    public TextboxWidget(final QuestionField questionField, final QLInterpreter qlIntepreter, final VariableTable symbolTable) {
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
                symbolTable.setVariable(questionField.getVariable(), new StringValue(widget.getText()));
                qlIntepreter.interpret();
            }
        });
    }

    @Override
    public Component getWidgetComponent() {
        return widget;
    }
}
