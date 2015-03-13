package org.uva.student.calinwouter.qlqls.application.gui.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.ql.QLGUI;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.QLIntepreter;
import org.uva.student.calinwouter.qlqls.ql.model.ComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.FormField;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;
import org.uva.student.calinwouter.qlqls.qls.model.components.ComputedValue;

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

    public LabelWithWidgetWidget(final AbstractFormField model, StylingSettings stylingSettings, IWidget widget,
                                 final FormInterpreter formInterpreter) {
        final Label fieldLabel = new Label();
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

        formInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                try {
                    fieldLabel.setText(formInterpreter.getLabelForField(model.getIdent()));
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

    public LabelWithWidgetWidget(final FormField formField, StylingSettings stylingSettings, IWidget widget,
                                 final QLIntepreter qlIntepreter, final QLGUI qlgui) {
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
