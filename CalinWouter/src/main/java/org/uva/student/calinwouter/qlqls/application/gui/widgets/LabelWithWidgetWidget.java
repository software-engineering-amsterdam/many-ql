package org.uva.student.calinwouter.qlqls.application.gui.widgets;

import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
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

    public LabelWithWidgetWidget(final AbstractFormField model, StylingSettings stylingSettings, IWidget widget,
                                 final FormInterpreter formInterpreter) {
        final Label fieldLabel = new Label();
        labelWithWidgetWidget = new JPanel();
        labelWithWidgetWidget.add(fieldLabel);
        System.out.println(widget.getClass());
        labelWithWidgetWidget.add(widget.getWidgetComponent());

        System.out.println(stylingSettings.getFont() +","+ 0 +","+ stylingSettings.getFontSize());

        fieldLabel.setFont(new Font(stylingSettings.getFont(), 0, stylingSettings.getFontSize()));
        fieldLabel.setForeground(new Color(stylingSettings.getColor()));
        widget.getWidgetComponent().setSize(stylingSettings.getWidth(), widget.getWidgetComponent().getSize().height);
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

}
