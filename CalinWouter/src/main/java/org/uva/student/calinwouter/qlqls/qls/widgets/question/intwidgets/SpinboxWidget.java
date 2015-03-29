package org.uva.student.calinwouter.qlqls.qls.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SpinboxWidget implements IWidget {
    private final JSpinner spinner;
    private String questionIdentifier;
    private QLInterpreter qlInterpreter;
    private StateWrapper stateWrapper;

    public Component getWidgetComponent() {
        return spinner;
    }

    public void resetValue() {
        spinner.setValue(0);
    }

    private ChangeListener createChangeListener() {
        return new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                final VariableTable variableTable = stateWrapper.getVariableTable();
                final Integer integer = (Integer) spinner.getValue();
                final IntegerValue integerValue = new IntegerValue(integer);
                variableTable.setVariable(questionIdentifier, integerValue);
                VariableTable newVariableTable = qlInterpreter.interpret(variableTable);
                stateWrapper.setVariableTable(newVariableTable);
            }
        };
    }

    private JSpinner createSpinnerUI() {
        JSpinner spinner = new JSpinner(new SpinnerNumberModel());
        spinner.addChangeListener(createChangeListener());
        return spinner;
    }

    public SpinboxWidget(String questionIdentifier, QLInterpreter qlInterpreter, StateWrapper stateWrapper) {
        this.questionIdentifier = questionIdentifier;
        this.qlInterpreter = qlInterpreter;
        this.stateWrapper = stateWrapper;
        this.spinner = createSpinnerUI();
    }

}
