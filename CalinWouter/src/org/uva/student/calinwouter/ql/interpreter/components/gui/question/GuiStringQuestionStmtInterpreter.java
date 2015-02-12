package org.uva.student.calinwouter.ql.interpreter.components.gui.question;

import org.uva.student.calinwouter.ql.generated.node.AQuestionStmt;
import org.uva.student.calinwouter.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.types.TString;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GuiStringQuestionStmtInterpreter {
    final FormInterpreter formInterpreter;
    final AQuestionStmt node;

    public Component interpret() {
        final JTextField jTextField = new JTextField();
        jTextField.setText(formInterpreter.getField(node.getIdent().getText()) != null
                ? formInterpreter.getField(node.getIdent().getText()).toString()
                : "" );
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!update(jTextField.getText())) {
                    update(null);
                }
            }
        });
        jTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!update(jTextField.getText())) {
                    update(null);
                }
            }
        });
        return jTextField;
    }

    boolean update(String value) {
        formInterpreter.setField(node.getIdent().getText(), new TString(value));
        return false;
    }

    public GuiStringQuestionStmtInterpreter(FormInterpreter formInterpreter, AQuestionStmt node) {
        this.formInterpreter = formInterpreter;
        this.node = node;
    }
}
