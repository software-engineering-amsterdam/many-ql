package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

import java.util.HashMap;

public class Question extends AbstractFormField<Question> {

    public void applyWidget(IQuestionWidgetCallback widgetCallback) {
        // TODO call the widget based on the type.
        widgetCallback.caseCheckboxWidget(this);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseQuestion(this);
    }

    public Question() {
        arguments = new HashMap<Object, Object>();
    }

}
