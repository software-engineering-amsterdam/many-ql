package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.textwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;
import org.uva.student.calinwouter.qlqls.ql.types.TString;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class TextboxWidget implements IWidget,TypeCallback {
    private JTextField widget;
    private HeadlessFormInterpreter headlessFormInterpreter;
    private Question question;

    public TextboxWidget(final Question question, final HeadlessFormInterpreter headlessFormInterpreter, final TypeDescriptor typeDescriptor) {
        this.widget = new JTextField(20);
        this.headlessFormInterpreter = headlessFormInterpreter;
        this.question = question;

        widget.getDocument().addDocumentListener(new DocumentListener(){
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
                typeDescriptor.callTypeMethod(TextboxWidget.this);
                headlessFormInterpreter.interpret();
            }
        });
    }

    @Override
    public Component getWidget() {
        return widget;
    }

    @Override
    public void usesBoolean() {
        //does nothing as the widget is only meant for String and Int boxes
    }

    @Override
    public void usesInteger() {
        try {
            headlessFormInterpreter.setField(question.getFieldName(), new TInteger(Integer.parseInt(widget.getText())));
        }
        catch(NumberFormatException e) {
            headlessFormInterpreter.setField(question.getFieldName(), null);
        }
        }

    @Override
    public void usesString() {
        headlessFormInterpreter.setField(question.getFieldName(), new TString(widget.getText()));
    }
}
