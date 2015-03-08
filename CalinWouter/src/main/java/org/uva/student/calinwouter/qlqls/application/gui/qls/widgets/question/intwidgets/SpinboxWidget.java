package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SpinboxWidget implements IWidget {
    private JSpinner spinner;

    public SpinboxWidget(final Question question, final HeadlessFormInterpreter headlessFormInterpreter) {
        spinner = new JSpinner(new SpinnerNumberModel());

        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                headlessFormInterpreter.setField(question.getIdent(), new IntegerValue(Integer.parseInt(spinner.getValue().toString())));
                headlessFormInterpreter.interpret();
            }
        });
    }

    @Override
    public Component getWidget() {
        return spinner;
    }
}
