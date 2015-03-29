package org.uva.student.calinwouter.qlqls.qls.gui.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.ql.gui.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BooleanValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.Radio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioWidget implements IWidget {
    private final String questionIdentifier;
    private final QLInterpreter qlInterpreter;
    private final StateWrapper stateWrapper;
    private final JPanel btnPanelYesNo;
    private final Radio radio;
    private final JRadioButton yesRadioButton, noRadioButton;

    public Component getWidgetComponent() {
        return btnPanelYesNo;
    }

    public void resetValue() {
        yesRadioButton.setSelected(false);
        noRadioButton.setSelected(false);
    }

    private ItemListener createRadioSelectedEventListener(final boolean radioSelectionType) {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                final VariableTable variableTable = stateWrapper.getVariableTable();
                final BooleanValue radioSelectionTypeValue = new BooleanValue(radioSelectionType);
                variableTable.setVariable(questionIdentifier, radioSelectionTypeValue);
                final VariableTable newVariableTable = qlInterpreter.interpret(variableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        };
    }

    private void initializeEventListeners() {
        yesRadioButton.addItemListener(createRadioSelectedEventListener(true));
        noRadioButton.addItemListener(createRadioSelectedEventListener(false));
    }

    private void initializeButtonGroup() {
        ButtonGroup btnGroupYesNo = new ButtonGroup();
        btnGroupYesNo.add(yesRadioButton);
        btnGroupYesNo.add(noRadioButton);
    }

    private void initializeRadioButtons() {
        btnPanelYesNo.add(yesRadioButton);
        btnPanelYesNo.add(noRadioButton);
    }

    private String getYesLabel() {
        return radio.getYesLabel();
    }

    private String getNoLabel() {
        return radio.getNoLabel();
    }

    public RadioWidget(String questionIdentifier, QLInterpreter qlInterpreter, StateWrapper stateWrapper, Radio radio) {
        this.questionIdentifier = questionIdentifier;
        this.qlInterpreter = qlInterpreter;
        this.stateWrapper = stateWrapper;
        this.btnPanelYesNo = new JPanel();
        this.radio = radio;
        this.yesRadioButton = new JRadioButton(getYesLabel());
        this.noRadioButton = new JRadioButton(getNoLabel());
        initializeButtonGroup();
        initializeRadioButtons();
        initializeEventListeners();
    }
}
