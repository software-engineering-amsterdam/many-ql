package org.uva.student.calinwouter.qlqls.application.gui.ql.widgets;

import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CheckBoxWidget {
    private JCheckBox checkBox;

    public JCheckBox getWidget() {
        return checkBox;
    }

    public CheckBoxWidget(final String identifier, final FormInterpreter formInterpreter) {
        checkBox = new JCheckBox();

        checkBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                formInterpreter.setField(identifier, new BoolValue(checkBox.isSelected()));
                formInterpreter.interpret();
            }
        });
    }
}
