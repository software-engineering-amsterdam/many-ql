package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

// TODO
public class Spinbox extends AbstractWidget<Spinbox> {

    @Override
    public void apply(IModel iModel) {
        iModel.caseSpinbox(this);
    }

    @Override
    public void applyWidget(Question question, IQuestionWidgetCallback widgetCallback, WidgetSettingsModel widgetSettingsModel) {
        widgetCallback.caseSpinboxWidget(question, widgetSettingsModel);
    }

    @Override
    public void usesInteger() {
        return;
    }

}
