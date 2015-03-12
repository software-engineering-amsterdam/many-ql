package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class IntboxWidget implements IWidget {
    private JTextField widget;

    public IntboxWidget(final Question question, final FormInterpreter formInterpreter) {
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
                    formInterpreter.setField(question.getIdent(), new IntegerValue(Integer.parseInt(widget.getText())));
                } catch(NumberFormatException e) {
                    formInterpreter.setField(question.getIdent(), new IntegerValue(0));
                }
                formInterpreter.interpret();
            }
        });
    }

    @Override
    public Component getWidgetComponent() {
        return widget;
    }
}
