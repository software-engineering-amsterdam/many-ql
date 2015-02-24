package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.types.TypeModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

import java.util.HashMap;

// TODO really ugly construction!!!!
public class Question extends AbstractFormField<Question> implements TypeCallback {
    private IQuestionWidgetCallback widgetCallback;

    public void applyWidget(IQuestionWidgetCallback widgetCallback, TypeDescriptor<?> typeDescriptor) {
        this.widgetCallback = widgetCallback;
        typeDescriptor.callTypeMethod(this);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseQuestion(this);
    }

    public Question() {
        arguments = new HashMap<Object, Object>();
    }

    @Override
    public void usesBoolean() {
        // TODO use default.
        widgetCallback.caseCheckboxWidget(this);
    }

    @Override
    public void usesInteger() {
        // TODO use default.
        widgetCallback.caseIntboxWidget(this);
    }

    @Override
    public void usesString() {
        // TODO use default.
        widgetCallback.caseTextboxWidget(this);
    }
}
