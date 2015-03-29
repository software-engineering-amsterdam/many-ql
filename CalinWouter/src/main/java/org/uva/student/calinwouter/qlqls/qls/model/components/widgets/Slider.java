package org.uva.student.calinwouter.qlqls.qls.model.components.widgets;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;

import javax.swing.*;

public class Slider extends AbstractWidget {
    private final Integer min;
    private final Integer max;

    @Override
    public <T> T createWidget(IQuestionWidgetCallback<T> widgetCallback) {
        return widgetCallback.createWidget(this);
    }

    public BoundedRangeModel createRange() {
        return new DefaultBoundedRangeModel(0, max - min, min, max);
    }

    public Slider(Integer min, Integer max) {
        assert(min != null && max != null);
        this.min = min;
        this.max = max;
    }
}
