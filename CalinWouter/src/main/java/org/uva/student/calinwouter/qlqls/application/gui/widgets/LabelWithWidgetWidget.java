package org.uva.student.calinwouter.qlqls.application.gui.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.ql.QLGUI;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.model.AbstractFormField;
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

    public LabelWithWidgetWidget(final org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField model, StylingSettings stylingSettings, IWidget widget,
                                 final QLInterpreter qlIntepreter) {
        final Label fieldLabel = new Label();
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

        try {
            fieldLabel.setText(qlIntepreter.getForm().getLabelForField(model.getIdent()));
            labelWithWidgetWidget.setVisible(true);
        } catch (LabelNotAvailableException e) {
            fieldLabel.setText("-");
            labelWithWidgetWidget.setVisible(false);
        }

        qlIntepreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                try {
                    fieldLabel.setText(qlIntepreter.getForm().getLabelForField(model.getIdent()));
                    labelWithWidgetWidget.setVisible(true);
                } catch (LabelNotAvailableException e) {
                    fieldLabel.setText("-");
                    labelWithWidgetWidget.setVisible(false);
                }
                fieldLabel.invalidate();
                labelWithWidgetWidget.revalidate();
            }
        });
    }

    public LabelWithWidgetWidget(final AbstractFormField formField, StylingSettings stylingSettings, IWidget widget,
                                 final QLInterpreter qlIntepreter, final QLGUI qlgui) {
        final Label fieldLabel = new Label(formField.getLabel());
        labelWithWidgetWidget = new JPanel();
        labelWithWidgetWidget.add(fieldLabel);
        System.out.println(widget.getClass());
        labelWithWidgetWidget.add(widget.getWidgetComponent());

        if(stylingSettings != null) {
            System.out.println(stylingSettings.getFont() + "," + 0 + "," + stylingSettings.getFontSize());

            fieldLabel.setFont(new Font(stylingSettings.getFont(), 0, stylingSettings.getFontSize()));
            fieldLabel.setForeground(new Color(stylingSettings.getColor()));
            widget.getWidgetComponent().setSize(stylingSettings.getWidth(), widget.getWidgetComponent().getSize().height);
        }

        qlIntepreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                try {
                    fieldLabel.setText(formField.getLabel());
                    labelWithWidgetWidget.setVisible(true);
                } catch (NullPointerException e) {
                    fieldLabel.setText("-");
                    labelWithWidgetWidget.setVisible(false);
                }
                fieldLabel.invalidate();
                labelWithWidgetWidget.revalidate();
                qlgui.repaintFrame();
            }
        });
    }

}
