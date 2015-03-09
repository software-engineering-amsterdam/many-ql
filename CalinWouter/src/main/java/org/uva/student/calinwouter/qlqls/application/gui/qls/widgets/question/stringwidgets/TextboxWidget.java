package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.stringwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class TextboxWidget implements IWidget {
    private JTextField widget;

    public TextboxWidget(final Question question, final HeadlessFormInterpreter headlessFormInterpreter) {
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
                headlessFormInterpreter.setField(question.getIdent(), new StringValue(widget.getText()));
                headlessFormInterpreter.interpret();
            }
        });
    }

    @Override
    public Component getWidget() {
        return widget;
    }
}
