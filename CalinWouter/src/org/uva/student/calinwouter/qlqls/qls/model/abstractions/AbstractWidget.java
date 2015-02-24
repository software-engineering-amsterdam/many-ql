package org.uva.student.calinwouter.qlqls.qls.model.abstractions;

import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

// TODO check if invoking this model fails the interpreter.
public abstract class AbstractWidget<T> extends AbstractModel<T> {

    public abstract void applyWidget(Question question, IQuestionWidgetCallback widgetCallback, WidgetSettingsModel widgetSettingsModel);

}
