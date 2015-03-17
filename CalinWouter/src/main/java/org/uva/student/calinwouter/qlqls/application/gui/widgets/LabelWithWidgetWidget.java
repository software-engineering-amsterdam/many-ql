package org.uva.student.calinwouter.qlqls.application.gui.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;

import javax.swing.*;
import java.awt.*;

/**
 * This widget is basically a (Label + Widget) Widget.
 */
public class LabelWithWidgetWidget implements IWidget {
    private JPanel labelWithWidgetWidget;
    private IWidget widget;

    @Override
    public Component getWidgetComponent() {
        return labelWithWidgetWidget;
    }

    @Override
    public void resetValue() {
        widget.resetValue();
    }

    public LabelWithWidgetWidget(final String label, final String identifier, StylingSettings stylingSettings, final IWidget widget, final VariableTableWrapper variableTableWrapper) {
        this.widget = widget;
        final Label fieldLabel = new Label(label);
        labelWithWidgetWidget = new JPanel();
        labelWithWidgetWidget.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelWithWidgetWidget.add(fieldLabel);
        labelWithWidgetWidget.add(widget.getWidgetComponent());

        if(stylingSettings != null) {
            fieldLabel.setFont(new Font(stylingSettings.getFont(), 0, stylingSettings.getFontSize()));
            fieldLabel.setForeground(new Color(stylingSettings.getColor()));
            widget.getWidgetComponent().setSize(stylingSettings.getWidth(), widget.getWidgetComponent().getSize().height);
        }

        if(variableTableWrapper.getVariableTable().isSet(identifier))
            labelWithWidgetWidget.setVisible(true);
        else
            labelWithWidgetWidget.setVisible(false);

        variableTableWrapper.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                if(variableTableWrapper.getVariableTable().isSet(identifier))
                    labelWithWidgetWidget.setVisible(true);
                else {
                    labelWithWidgetWidget.setVisible(false);
                    LabelWithWidgetWidget.this.resetValue();
                }
                labelWithWidgetWidget.revalidate();
            }
        });
    }

}
