package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.ql.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.Combo;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

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

    public ComboWidget(final Question question, final QLInterpreter qlIntepreter, final VariableTableWrapper variableTableWrapper, Combo combo) {
        yesNoComboBox = new JComboBox(new String[]{combo.getYesLbl(), combo.getNoLbl()});
        yesNoComboBox.setSelectedIndex(-1);

        yesNoComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (yesNoComboBox.getSelectedIndex() == 0) {
                    System.out.println("true");
                    variableTableWrapper.getVariableTable().setVariable(question.getIdent(), new BoolValue(true));
                    qlIntepreter.interpret(variableTableWrapper.getVariableTable());
                    return;
                }
                variableTableWrapper.getVariableTable().setVariable(question.getIdent(), new BoolValue(false));
                VariableTable newVariableTable = qlIntepreter.interpret(variableTableWrapper.getVariableTable());
                variableTableWrapper.setVariableTable(newVariableTable);
            }
        });
    }
}
