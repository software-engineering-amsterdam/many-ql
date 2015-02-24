package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

public class Checkbox extends AbstractWidget<Checkbox> {
    @Override
    public void apply(IModel iModel) {
        iModel.caseCheckbox(this);
    }

    @Override
    public void applyWidget(Question question, IQuestionWidgetCallback widgetCallback, WidgetSettingsModel widgetSettingsModel) {
        widgetCallback.caseCheckboxWidget(question, widgetSettingsModel);
    }
}
