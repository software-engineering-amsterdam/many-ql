package org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.components.ComputedValue;

import javax.swing.*;
import java.awt.*;

/**
 * This widget is used for displaying the value of a computed value field.
 */
public class LabelWidget implements IWidget {
    private JLabel valueLabel;


    public LabelWidget(final ComputedValue computedValue, final FormInterpreter formInterpreter) {
        valueLabel = new JLabel();
        formInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                try {
                    valueLabel.setText(formInterpreter
                            .getField(computedValue.getIdent()).getValue().toString());
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
