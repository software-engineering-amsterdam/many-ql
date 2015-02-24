package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractComponent;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractModel;
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
    public void applyWidget(Question question, IQuestionWidgetCallback widgetCallback) {
        widgetCallback.caseSpinboxWidget(question);
    }

}
