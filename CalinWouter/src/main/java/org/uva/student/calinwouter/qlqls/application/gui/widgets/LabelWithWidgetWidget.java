package org.uva.student.calinwouter.qlqls.application.gui.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;

import javax.swing.*;
import java.awt.*;

/**
 * This widget is basically a (Label + Widget) Widget.
 */
// TODO QL uses this class, but this class uses StyleSheet (which is part of QLS).
public class LabelWithWidgetWidget implements IWidget {
    private final JPanel labelWithWidgetWidget;
    private final IWidget widget;
    private final Label fieldLabel;
    private final StateWrapper stateWrapper;
    private final StylingSettings stylingSettings;
    private final String identifier;

    @Override
    public Component getWidgetComponent() {
        return labelWithWidgetWidget;
    }

    @Override
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
        if (setMyVisibility()) {
            LabelWithWidgetWidget.this.resetValue();
        }
    }

    private void setStylingSettingsIfAvailable() {
        if(stylingSettings != null) {
            fieldLabel.setFont(new Font(stylingSettings.getFont(), 0, stylingSettings.getFontSize()));
            fieldLabel.setForeground(new Color(stylingSettings.getColor()));
            widget.getWidgetComponent().setSize(stylingSettings.getWidth(), widget.getWidgetComponent().getSize().height);
        }
    }

    private void createEventListener() {
        stateWrapper.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
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

    private void initializeWidget() {
        setStylingSettingsIfAvailable();
        setMyVisibility();
        createEventListener();
    }

    public LabelWithWidgetWidget(String label, String identifier, StylingSettings stylingSettings,
                                 IWidget widget, StateWrapper stateWrapper) {
        this.widget = widget;
        this.fieldLabel = createFieldLabel(label);
        this.labelWithWidgetWidget = createUserInterface();
        this.stylingSettings = stylingSettings;
        this.stateWrapper = stateWrapper;
        this.identifier = identifier;
        initializeWidget();
    }

    public LabelWithWidgetWidget(String label, String identifier, IWidget widget, StateWrapper stateWrapper) {
        this(label, identifier, null, widget, stateWrapper);
    }

}
