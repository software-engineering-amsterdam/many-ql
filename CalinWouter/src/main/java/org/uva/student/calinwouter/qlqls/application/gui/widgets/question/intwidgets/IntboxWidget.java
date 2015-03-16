package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class IntboxWidget implements IWidget {
    private JTextField widget;

    public IntboxWidget(final Question question, final QLInterpreter qlIntepreter, final VariableTable symbolTable) {
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
                try {
                    symbolTable.setVariable(question.getIdent(), new IntegerValue(Integer.parseInt(widget.getText())));
                } catch(NumberFormatException e) {
                    symbolTable.setVariable(question.getIdent(), new IntegerValue(0));
                }
                qlIntepreter.interpret();
            }
        });
    }

    public IntboxWidget(final QuestionField questionField, final QLInterpreter qlIntepreter, final VariableTable symbolTable) {
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
                try {
                    symbolTable.setVariable(questionField.getVariable(), new IntegerValue(Integer.parseInt(widget.getText())));
                } catch(NumberFormatException e) {
                    symbolTable.setVariable(questionField.getVariable(), new IntegerValue(0));
                }
                qlIntepreter.interpret();
            }
        });
    }

    @Override
    public Component getWidgetComponent() {
        return widget;
    }
}