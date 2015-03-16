package org.uva.student.calinwouter.qlqls.application.gui.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.ql.QLGUI;
import org.uva.student.calinwouter.qlqls.application.gui.ql.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.model.AbstractStaticFormField;
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

    public LabelWithWidgetWidget(final String label, final String identifier, StylingSettings stylingSettings, IWidget widget, final VariableTableWrapper variableTableWrapper) {
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

        variableTableWrapper.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            //TODO this needs to be changed
            public void onStateChanged() {
                //if(variableTableWrapper.getVariableTable().getVariable(identifier))
                //labelWithWidgetWidget.setVisible(true);
                //labelWithWidgetWidget.setVisible(false);
                fieldLabel.invalidate();
                labelWithWidgetWidget.revalidate();
            }
        });
    }

}
