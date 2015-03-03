package org.uva.student.calinwouter.qlqls.qls.model.abstractions;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

// TODO check if invoking this model fails the interpreter.
public abstract class AbstractWidget<T> extends AbstractModel<T> implements TypeCallback {
    public abstract void applyWidget(Question question, IQuestionWidgetCallback widgetCallback, WidgetSettingsModel widgetSettingsModel);

    @Override
    public void usesBoolean() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void usesInteger() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void usesString() {
        throw new UnsupportedOperationException();
    }
}
