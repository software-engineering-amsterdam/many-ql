package org.uva.student.calinwouter.qlqls.qls.model.components.widgets;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;

public class Combo extends AbstractWidget {
    private final String yesLbl;
    private final String noLbl;

    @Override
    public <T> T createWidget(IQuestionWidgetCallback<T> widgetCallback) {
        return widgetCallback.createWidget(this);
    }

    public String[] createYesNoArray() {
        return new String[] { yesLbl, noLbl };
    }

    public Combo(String yesLbl, String noLbl) {
        this.yesLbl = yesLbl;
        this.noLbl = noLbl;
    }
}
