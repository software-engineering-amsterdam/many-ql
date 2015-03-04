package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;
import org.uva.student.calinwouter.qlqls.qls.model.components.Radio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioWidget implements IWidget {
    private JPanel btnPanelYesNo;

    @Override
    public Component getWidget() {
        return btnPanelYesNo;
    }

    public RadioWidget(final Question question, final HeadlessFormInterpreter headlessFormInterpreter, Radio radio) {
        ButtonGroup btnGroupYesNo = new ButtonGroup();
        JRadioButton yesBtn = new JRadioButton(radio.getYesLbl());
        JRadioButton noBtn = new JRadioButton(radio.getNoLbl());
        btnGroupYesNo.add(yesBtn);
        btnGroupYesNo.add(noBtn);
        btnPanelYesNo = new JPanel();
        btnPanelYesNo.add(yesBtn);
        btnPanelYesNo.add(noBtn);

        yesBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("true");
                headlessFormInterpreter.setField(question.getFieldName(), new BoolValue(true));
                headlessFormInterpreter.interpret();
            }
        });

        noBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("false");
                headlessFormInterpreter.setField(question.getFieldName(), new BoolValue(false));
                headlessFormInterpreter.interpret();
            }
        });
    }
}
