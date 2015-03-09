package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;

public class Spinbox extends AbstractWidget {


    @Override
    public void applyWidget(final IQuestionWidgetCallback widgetCallback) {
        widgetCallback.widgetIsSpinboxWidget(this);
    }
}
