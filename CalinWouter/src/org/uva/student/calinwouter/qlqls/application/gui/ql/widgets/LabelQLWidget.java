package org.uva.student.calinwouter.qlqls.application.gui.ql.widgets;


import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;

import javax.swing.*;

public class LabelQLWidget {
    private JLabel label;

    public JLabel getWidget() {
        return label;
    }

    public LabelQLWidget(final String identifier, final HeadlessFormInterpreter headlessFormInterpreter){
        label = new JLabel();

        headlessFormInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                try {
                    label.setText(headlessFormInterpreter
                            .getField(identifier).getValue().toString());
                } catch (NullPointerException e) {
                    label.setText("-");
                }
            }
        });
    }
}
