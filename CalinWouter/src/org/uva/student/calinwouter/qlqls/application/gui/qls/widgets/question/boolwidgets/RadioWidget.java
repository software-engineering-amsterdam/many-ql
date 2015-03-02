package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TBool;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioWidget implements IWidget {
    private JRadioButton yesBtn;
    private JRadioButton noBtn;
    private JLabel btnGroupYesNo;

    @Override
    public Component getWidget() {
        return btnGroupYesNo;
    }

    public RadioWidget(final Question question, final HeadlessFormInterpreter headlessFormInterpreter) {
        yesBtn = new JRadioButton("Yes");
        noBtn = new JRadioButton("No");
        btnGroupYesNo = new JLabel();
        btnGroupYesNo.add(yesBtn);
        btnGroupYesNo.add(noBtn);

        yesBtn.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                noBtn.setSelected(false);
                headlessFormInterpreter.setField(question.getFieldName(), new TBool(true));
                headlessFormInterpreter.interpret();
            }
        });

        noBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                yesBtn.setSelected(false);
                headlessFormInterpreter.setField(question.getFieldName(), new TBool(false));
                headlessFormInterpreter.interpret();
            }
        });
    }
}
