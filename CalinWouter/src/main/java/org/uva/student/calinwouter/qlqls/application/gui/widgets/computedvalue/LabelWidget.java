package org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue;

import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;

import javax.swing.*;
import java.awt.*;

/**
 * This widget is used for displaying the value of a computed value field.
 */
public class LabelWidget implements IWidget {
    private JLabel valueLabel;


    public LabelWidget(final String questionIdentifier , final VariableTableWrapper variableTableWrapper) {
        valueLabel = new JLabel();

        variableTableWrapper.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                if(variableTableWrapper.getVariableTable().isSet(questionIdentifier)) {
                    valueLabel.setText(variableTableWrapper.getVariableTable().getVariable(questionIdentifier).getValue().toString());
                }else
                    valueLabel.setText("-");
                valueLabel.revalidate();
            }
        });
    }

    @Override
    public Component getWidgetComponent() {
        return valueLabel;
    }

    @Override
    public void resetValue() {
        valueLabel.setText("");
    }

}
