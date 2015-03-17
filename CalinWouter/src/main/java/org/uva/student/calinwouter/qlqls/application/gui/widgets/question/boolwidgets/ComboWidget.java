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
    private final String questionIdentifier;
    private final QLInterpreter qlInterpreter;
    private final StateWrapper stateWrapper;
    private final JComboBox yesNoComboBox;

    @Override
    public Component getWidgetComponent() {
        return yesNoComboBox;
    }

    @Override
    public void resetValue() {
        yesNoComboBox.setSelectedIndex(-1);
    }

    private JComboBox createYesNoComboDombo(Combo combo) {
        final String yesLabel = combo.getYesLbl();
        final String noLabel = combo.getNoLbl();
        return new JComboBox<String>(new String[] { yesLabel, noLabel });
    }

    private void setComboValue(VariableTable variableTable) {
        final boolean isFirstSelected = yesNoComboBox.getSelectedIndex() == 0;
        final BoolValue selectionBasedValue = new BoolValue(isFirstSelected);
        variableTable.setVariable(questionIdentifier, selectionBasedValue);
    }

    private ItemListener createComboChangeListener() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                VariableTable currentVariableTable = stateWrapper.getVariableTable();
                setComboValue(currentVariableTable);
                VariableTable newVariableTable = qlInterpreter.interpret(currentVariableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        };
    }

    public ComboWidget(String questionIdentifier, QLInterpreter qlInterpreter, StateWrapper stateWrapper, Combo combo) {
        this.questionIdentifier = questionIdentifier;
        this.qlInterpreter = qlInterpreter;
        this.stateWrapper = stateWrapper;
        this.yesNoComboBox = createYesNoComboDombo(combo);
        resetValue();
        yesNoComboBox.addItemListener(createComboChangeListener());
    }
}
