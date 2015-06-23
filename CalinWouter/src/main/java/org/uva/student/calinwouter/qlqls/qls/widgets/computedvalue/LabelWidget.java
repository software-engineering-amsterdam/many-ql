package org.uva.student.calinwouter.qlqls.qls.widgets.computedvalue;

import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;

import javax.swing.*;
import java.awt.*;

/**
 * This widget is used for displaying the value of a computed value field.
 */
public class LabelWidget implements IWidget {
    private final String questionIdentifier;
    private final StateWrapper stateWrapper;
    private final JLabel valueLabel;

    private String createNotSetText() {
        return "-";
    }

    private String createText(VariableTable variableTable, String questionIdentifier) {
        if (variableTable.isSet(questionIdentifier)) {
            return variableTable.getVariable(questionIdentifier).toString();
        }
        return createNotSetText();
    }

    private ChangedStateEventListener createChangedStateEventListener() {
        return new ChangedStateEventListener() {
            public void onStateChanged() {
                VariableTable variableTable = stateWrapper.getVariableTable();
                valueLabel.setText(createText(variableTable, questionIdentifier));
                valueLabel.revalidate();
            }
        };
    }

    public LabelWidget(String questionIdentifier, StateWrapper stateWrapper) {
        this.questionIdentifier = questionIdentifier;
        this.stateWrapper = stateWrapper;
        this.valueLabel = new JLabel();
        final ChangedStateEventListener textboxChangedStateEventListener = createChangedStateEventListener();
        stateWrapper.subscribeChangedStateEventListener(textboxChangedStateEventListener);
    }

    public Component getWidgetComponent() {
        return valueLabel;
    }

    public void resetValue() {
        valueLabel.setText(createNotSetText());
    }

}
