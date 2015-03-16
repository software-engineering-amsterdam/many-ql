package org.uva.student.calinwouter.qlqls.application.gui.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.AbstractSwingGUI;
import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.ql.QLGUI;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;

import javax.swing.*;
import java.awt.*;

/**
 * Name may be confusing. This widget is basically a (Label + Widget) Widget.
 */
public class LabelWithWidgetWidget implements IWidget {
    private JPanel labelWithWidgetWidget;

    @Override
    public Component getWidgetComponent() {
        return labelWithWidgetWidget;
    }

    public LabelWithWidgetWidget(final String label, final String identifier, StylingSettings stylingSettings, final IWidget widget, final VariableTableWrapper variableTableWrapper, final AbstractSwingGUI gui) {
        final Label fieldLabel = new Label(label);
        labelWithWidgetWidget = new JPanel();
        labelWithWidgetWidget.add(fieldLabel);
        //System.out.println(widget.getClass());
        labelWithWidgetWidget.add(widget.getWidgetComponent());

        if(stylingSettings != null) {
            System.out.println(stylingSettings.getFont() + "," + 0 + "," + stylingSettings.getFontSize());

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
                if(variableTableWrapper.getVariableTable().isSet(identifier)) {
                    labelWithWidgetWidget.setVisible(true);
                }
                else {
                    labelWithWidgetWidget.setVisible(false);
                }
                labelWithWidgetWidget.revalidate();
            }
        });
    }

}
