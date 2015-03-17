package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.StateWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.Combo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboWidget implements IWidget {
    private JComboBox yesNoComboBox;

    @Override
    public Component getWidgetComponent() {
        return yesNoComboBox;
    }

    @Override
    public void resetValue() {
        yesNoComboBox.setSelectedIndex(-1);
    }

    public ComboWidget(final String questionIdentifier, final QLInterpreter qlInterpreter, final StateWrapper stateWrapper, Combo combo) {
        yesNoComboBox = new JComboBox(new String[]{combo.getYesLbl(), combo.getNoLbl()});
        yesNoComboBox.setSelectedIndex(-1);

        yesNoComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                VariableTable variableTable = stateWrapper.getVariableTable();
                if (yesNoComboBox.getSelectedIndex() == 0)
                    variableTable.setVariable(questionIdentifier, new BoolValue(true));
                else
                    variableTable.setVariable(questionIdentifier, new BoolValue(false));
                VariableTable newVariableTable = qlInterpreter.interpret(variableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        });

    }
}
