package org.uva.student.calinwouter.qlqls.application.gui.ql.widgets;


import org.uva.student.calinwouter.qlqls.ql.interpreter.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;

import javax.swing.*;

public class LabelQLWidget {
    private JLabel label;

    public JLabel getWidget() {
        return label;
    }

    public LabelQLWidget(final String identifier, final FormInterpreter formInterpreter) {
        label = new JLabel();

        formInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                try {
                    label.setText(formInterpreter
                            .getField(identifier).getValue().toString());
                } catch (NullPointerException e) {
                    label.setText("-");
                }
            }
        });
    }
}
