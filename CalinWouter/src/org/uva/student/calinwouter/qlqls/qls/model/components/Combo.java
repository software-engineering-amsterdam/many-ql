package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

public class Combo extends Radio {

    public Combo(QLSInterpreter qlsInterpreter) {
        super(qlsInterpreter);
    }

    @Override
    public void applyWidget(Question question, IQuestionWidgetCallback widgetCallback, WidgetSettingsModel widgetSettingsModel) {
        widgetCallback.caseComboWidget(question, widgetSettingsModel, this);
    }

    @Override
    public void usesBoolean() {
        return;
    }
}
