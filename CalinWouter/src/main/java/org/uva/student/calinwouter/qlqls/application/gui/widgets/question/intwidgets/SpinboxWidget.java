package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SpinboxWidget implements IWidget {
    private JSpinner spinner;

    public SpinboxWidget(final Question question, final QLInterpreter qlIntepreter, final VariableTableWrapper variableTableWrapper) {
        spinner = new JSpinner(new SpinnerNumberModel());

        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                variableTableWrapper.getVariableTable().setVariable(question.getIdent(), new IntegerValue(Integer.parseInt(spinner.getValue().toString())));
                VariableTable newVariableTable = qlIntepreter.interpret(variableTableWrapper.getVariableTable());
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
