package org.uva.student.calinwouter.qlqls.ql.gui.widgets;

import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BooleanValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxWidget implements IWidget {
    private final String questionIdentifier;
    private final QLInterpreter qlInterpreter;
    private final StateWrapper stateWrapper;
    private final JCheckBox checkbox;

    public Component getWidgetComponent() {
        return checkbox;
    }

    public void resetValue() {
        checkbox.setSelected(false);
    }

    private ItemListener createChangeListener() {
        return new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                VariableTable variableTable = stateWrapper.getVariableTable();
                variableTable.setVariable(questionIdentifier, new BooleanValue(checkbox.isSelected()));
                VariableTable newVariableTable = qlInterpreter.interpret(variableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        };
    }

    public CheckboxWidget(String questionIdentifier, QLInterpreter qlInterpreter, StateWrapper stateWrapper) {
        this.questionIdentifier = questionIdentifier;
        this.qlInterpreter = qlInterpreter;
        this.stateWrapper = stateWrapper;
        this.checkbox = new JCheckBox();
        checkbox.addItemListener(createChangeListener());
    }
}
