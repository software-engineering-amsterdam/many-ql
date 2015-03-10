package org.uva.student.calinwouter.qlqls.application.gui.ql.widgets;


import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextBoxWidget {
    private JTextField textField;

    public JTextField getWidget() {
        return textField;
    }

    public TextBoxWidget(final String identifier, final FormInterpreter formInterpreter) {
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
                try {
                    formInterpreter.setField(identifier, new IntegerValue(Integer.parseInt(textField.getText())));
                    formInterpreter.interpret();
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format introduced");
                }
            }
        });
    }
}
