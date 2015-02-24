package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntboxWidget extends TextboxWidget {

    // TODO add intbox specific implementation.
    public IntboxWidget(final Question question,final HeadlessFormInterpreter headlessFormInterpreter) {
        super(question, headlessFormInterpreter);

        widget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!widget.getText().equals("")) {
                    headlessFormInterpreter.setField(question.getFieldName(), new TInteger(Integer.parseInt(widget.getText())));
                    headlessFormInterpreter.interpret();
                }
            }
        });
    }
}
