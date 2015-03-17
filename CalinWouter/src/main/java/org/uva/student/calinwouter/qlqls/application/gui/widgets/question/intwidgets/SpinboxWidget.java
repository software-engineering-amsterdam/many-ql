package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SpinboxWidget implements IWidget {
    private JSpinner spinner;

    public SpinboxWidget(final String questionIdentifier, final QLInterpreter qlIntepreter, final VariableTableWrapper variableTableWrapper) {
        spinner = new JSpinner(new SpinnerNumberModel());

        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                VariableTable variableTable = variableTableWrapper.getVariableTable();
                variableTable.setVariable(questionIdentifier, new IntegerValue(Integer.parseInt(spinner.getValue().toString())));
                VariableTable newVariableTable = qlIntepreter.interpret(variableTable);
                variableTableWrapper.setVariableTable(newVariableTable);
            }
        });
    }

    @Override
    public Component getWidgetComponent() {
        return spinner;
    }

    @Override
    public void resetValue() {
        spinner.setValue(0);
    }
}
