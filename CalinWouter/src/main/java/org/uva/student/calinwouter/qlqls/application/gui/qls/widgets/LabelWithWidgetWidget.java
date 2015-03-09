package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets;

import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Name may be confusing. This widget is basically a (Label + Widget) Widget.
 */
public class LabelWithWidgetWidget implements IWidget {
    private JPanel labelWithWidgetWidget;

    @Override
    public Component getWidget() {
        return labelWithWidgetWidget;
    }

    public LabelWithWidgetWidget(final AbstractFormField model, Map<String, Object> widgetSettingsModel, IWidget widget,
                                 final HeadlessFormInterpreter headlessFormInterpreter) {
        final Label fieldLabel = new Label();
        labelWithWidgetWidget = new JPanel();
        labelWithWidgetWidget.add(fieldLabel);
        System.out.println(widget.getClass());
        labelWithWidgetWidget.add(widget.getWidget());
        fieldLabel.setFont(new Font("" + widgetSettingsModel.get("font"), 0, (Integer) widgetSettingsModel.get("font-size")));
        fieldLabel.setForeground(new Color((Integer) widgetSettingsModel.get("color")));
        widget.getWidget().setSize((Integer) widgetSettingsModel.get("width"), widget.getWidget().getSize().height);
        headlessFormInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                try {
                    fieldLabel.setText(headlessFormInterpreter.getLabelForField(model.getIdent()));
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
