package org.uva.student.calinwouter.qlqls.application.gui.ql.widgets;


import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextBoxWidget {
    private JTextField textField;

    public JTextField getWidget() {
        return textField;
    }

    public TextBoxWidget(final String identifier, final HeadlessFormInterpreter headlessFormInterpreter) {
        textField = new JTextField(20);

        textField.getDocument().addDocumentListener(new DocumentListener() {
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
                headlessFormInterpreter.setField(identifier, new IntegerValue(Integer.parseInt(textField.getText())));
                headlessFormInterpreter.interpret();
            }
        });
    }
}
