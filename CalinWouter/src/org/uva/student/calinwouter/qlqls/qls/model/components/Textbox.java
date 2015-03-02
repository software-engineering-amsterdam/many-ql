package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

public class Textbox extends AbstractWidget<Textbox> {

    public Textbox(QLSInterpreter qlsInterpreter) {
        super(qlsInterpreter);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseTextbox(this);
    }

    @Override
    public void applyWidget(Question question, IQuestionWidgetCallback widgetCallback, WidgetSettingsModel widgetSettingsModel) {
        widgetCallback.caseTextboxWidget(question, widgetSettingsModel);
    }

    @Override
    public void usesString() {
        return;
    }

    @Override
    public void usesInteger() {
        return;
    }
}
