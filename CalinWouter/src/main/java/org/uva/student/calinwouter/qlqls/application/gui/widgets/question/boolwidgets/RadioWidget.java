package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.StateWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.Radio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioWidget implements IWidget {
    private JPanel btnPanelYesNo;
    private JRadioButton yesBtn, noBtn;

    @Override
    public Component getWidgetComponent() {
        return btnPanelYesNo;
    }

    @Override
    public void resetValue() {
        yesBtn.setSelected(false);
        noBtn.setSelected(false);
    }

    public RadioWidget(final String questionIdentifier, final QLInterpreter qlInterpreter, final StateWrapper stateWrapper, Radio radio) {
        ButtonGroup btnGroupYesNo = new ButtonGroup();
        yesBtn = new JRadioButton(radio.getYesLbl());
        noBtn = new JRadioButton(radio.getNoLbl());
        btnGroupYesNo.add(yesBtn);
        btnGroupYesNo.add(noBtn);
        btnPanelYesNo = new JPanel();
        btnPanelYesNo.add(yesBtn);
        btnPanelYesNo.add(noBtn);

        yesBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                VariableTable variableTable = stateWrapper.getVariableTable();
                variableTable.setVariable(questionIdentifier, new BoolValue(true));
                VariableTable newVariableTable = qlInterpreter.interpret(variableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        });

        noBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                VariableTable variableTable = stateWrapper.getVariableTable();
                variableTable.setVariable(questionIdentifier, new BoolValue(false));
                VariableTable newVariableTable = qlInterpreter.interpret(variableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        });

    }
}
