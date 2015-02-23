package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.qls.model.ComputedValue;
import org.uva.student.calinwouter.qlqls.qls.model.IComputedValueWidgetCallback;

import java.awt.*;

public class ComputedValueWidgetFetcher implements IComputedValueWidgetCallback, IWidget {
    private IWidget widget;

    @Override
    public void caseLabelWidget(ComputedValue computedValue) {
        widget = new LabelWidget(computedValue);
    }

    @Override
    public Component getWidget() {
        return widget.getWidget();
    }
}
