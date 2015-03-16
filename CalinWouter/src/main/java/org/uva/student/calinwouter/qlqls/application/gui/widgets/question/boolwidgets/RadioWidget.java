package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.ql.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.Radio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioWidget implements IWidget {
    private JPanel btnPanelYesNo;

    @Override
    public Component getWidgetComponent() {
        return btnPanelYesNo;
    }

    public RadioWidget(final Question question, final QLInterpreter qlIntepreter, final VariableTableWrapper variableTableWrapper, Radio radio) {
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
                variableTableWrapper.getVariableTable().setVariable(question.getIdent(), new BoolValue(true));
                qlIntepreter.interpret(variableTableWrapper.getVariableTable());
            }
        });

        noBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("false");
                variableTableWrapper.getVariableTable().setVariable(question.getIdent(), new BoolValue(false));
                qlIntepreter.interpret(variableTableWrapper.getVariableTable());
            }
        });
    }
}
