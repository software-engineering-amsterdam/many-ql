package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

public class Checkbox extends AbstractWidget<Checkbox> {
    @Override
    public void apply(IModel iModel) {
        iModel.caseCheckbox(this);
    }

    @Override
    public void caseCheckbox(Checkbox checkbox) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void applyWidget(Question question, IQuestionWidgetCallback widgetCallback) {
        widgetCallback.caseCheckboxWidget(question);
    }
}
