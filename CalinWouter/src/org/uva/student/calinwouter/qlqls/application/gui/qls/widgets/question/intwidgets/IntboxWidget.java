package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;

public class IntboxWidget extends TextboxWidget {

    // TODO add intbox specific implementation.
    public IntboxWidget(final Question question,final HeadlessFormInterpreter headlessFormInterpreter) {
        super(question, headlessFormInterpreter);

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

            private void updateField() {
                try {
                    System.out.println("Changed all.");
                    headlessFormInterpreter.setField(question.getFieldName(), new TInteger(Integer.parseInt(widget.getText())));
                    headlessFormInterpreter.interpret();
                } catch(NumberFormatException e) {
                    headlessFormInterpreter.setField(question.getFieldName(), null);
                    headlessFormInterpreter.interpret();
                }
            }
        });
    }
}
