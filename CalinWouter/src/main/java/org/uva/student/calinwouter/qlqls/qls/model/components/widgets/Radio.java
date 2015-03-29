package org.uva.student.calinwouter.qlqls.qls.model.components.widgets;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;

public class Radio extends AbstractWidget {
    private final String yesLabel;
    private final String noLabel;

    public Radio(String yesLabel, String noLabel) {
        this.yesLabel = yesLabel;
        this.noLabel = noLabel;
    }

    @Override
    public <T> T createWidget(IQuestionWidgetCallback<T> widgetCallback) {
        return widgetCallback.createWidget(this);
    }
}
