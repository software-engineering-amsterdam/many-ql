package org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.interpreter.QLIntepreter;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SpinboxWidget implements IWidget {
    private JSpinner spinner;

    public SpinboxWidget(final Question question, final QLIntepreter qlIntepreter, final VariableTable symbolTable) {
        spinner = new JSpinner(new SpinnerNumberModel());

        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                symbolTable.setVariable(question.getIdent(), new IntegerValue(Integer.parseInt(spinner.getValue().toString())));
                qlIntepreter.interpret();
            }
        });
    }

    @Override
    public Component getWidgetComponent() {
        return spinner;
    }
}
