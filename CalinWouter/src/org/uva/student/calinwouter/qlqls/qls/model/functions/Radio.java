package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractComponent;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

import java.util.HashMap;
import java.util.List;

public class Radio extends AbstractWidget<Radio> {

    @Override
    public void apply(IModel iModel) {
        iModel.caseRadio(this);
    }

    @Override
    public void caseString(String string) {
        // TODO
    }

    @Override
    public void applyWidget(Question question, IQuestionWidgetCallback widgetCallback) {
        widgetCallback.caseRadioWidget(question);
    }
}
