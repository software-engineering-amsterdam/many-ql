package org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.qls.model.components.ComputedValue;

import javax.swing.*;
import java.awt.*;

/**
 * This widget is used for displaying the value of a computed value field.
 */
public class LabelWidget implements IWidget {
    private JLabel valueLabel;


    public LabelWidget(final ComputedValue computedValue, final QLInterpreter qlIntepreter, final VariableTable symbolTable) {
        valueLabel = new JLabel();
        qlIntepreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                try {
                    valueLabel.setText(symbolTable.getVariable(computedValue.getIdent()).getValue().toString());
                } catch (NullPointerException e) {
                    valueLabel.setText("-");
                }
            }
        });
    }

    public LabelWidget(final StaticComputedValueField staticComputedValueField, final QLInterpreter qlIntepreter, final VariableTable symbolTable) {
        valueLabel = new JLabel();
        qlIntepreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                try {
                    valueLabel.setText(symbolTable
                            .getVariable(staticComputedValueField.getVariable()).getValue().toString());
                } catch (NullPointerException e) {
                    valueLabel.setText("-");
                }
            }
        });
    }

    @Override
    public Component getWidgetComponent() {
        return valueLabel;
    }
}
