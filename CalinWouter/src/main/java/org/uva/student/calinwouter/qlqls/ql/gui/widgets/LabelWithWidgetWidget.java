package org.uva.student.calinwouter.qlqls.ql.gui.widgets;

import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;

import javax.swing.*;
import java.awt.*;

/**
 * This widget is basically a (Label + Widget) Widget.
 */
public class LabelWithWidgetWidget implements IWidget {
    private final JPanel labelWithWidgetWidget;
    private final IWidget widget;
    private final Label fieldLabel;
    private final StateWrapper stateWrapper;
    private final String identifier;

    public Component getWidgetComponent() {
        return labelWithWidgetWidget;
    }

    public void resetValue() {
        widget.resetValue();
    }

    private boolean setMyVisibility() {
        final VariableTable variableTable = stateWrapper.getVariableTable();
        final Boolean isVariableSet = variableTable.isSet(identifier);
        labelWithWidgetWidget.setVisible(isVariableSet);
        return isVariableSet;
    }

    private void resetVisibilityAndValue() {
        if ( !setMyVisibility()) {
            resetValue();
        }
    }

    protected void setLabelStylingSettings(Label fieldLabel) {
        // QL uses default styling settings. :-)
    }

    private void createEventListener() {
        stateWrapper.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            public void onStateChanged() {
                resetVisibilityAndValue();
                labelWithWidgetWidget.revalidate();
            }
        });
    }

    private JPanel createUserInterface() {
        final JPanel labelWithWidgetWidget = new JPanel();
        labelWithWidgetWidget.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelWithWidgetWidget.add(fieldLabel);
        labelWithWidgetWidget.add(widget.getWidgetComponent());
        return labelWithWidgetWidget;
    }

    private Label createFieldLabel(String label) {
        return new Label(label);
    }

    protected void initializeWidget() {
        setLabelStylingSettings(fieldLabel);
        setMyVisibility();
        createEventListener();
    }

    public LabelWithWidgetWidget(String label, String identifier, IWidget widget, StateWrapper stateWrapper) {
        this.widget = widget;
        this.fieldLabel = createFieldLabel(label);
        this.labelWithWidgetWidget = createUserInterface();
        this.stateWrapper = stateWrapper;
        this.identifier = identifier;
        initializeWidget();
    }

}
