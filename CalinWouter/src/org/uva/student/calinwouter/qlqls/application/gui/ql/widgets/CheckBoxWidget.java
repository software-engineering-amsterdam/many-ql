package org.uva.student.calinwouter.qlqls.application.gui.ql.widgets;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TBool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CheckBoxWidget {
    private JCheckBox checkBox;

    public JCheckBox getWidget() {
        return checkBox;
    }
    public CheckBoxWidget(final String identifier, final HeadlessFormInterpreter headlessFormInterpreter) {
        checkBox = new JCheckBox();

        checkBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                headlessFormInterpreter.setField(identifier, new TBool(checkBox.isSelected()));
                headlessFormInterpreter.interpret();
            }
        });
    }
}
