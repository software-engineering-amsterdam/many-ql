package org.uva.student.calinwouter.qlqls.ql.interfaces;

import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.Checkbox;

public interface IQlQuestionWidgetCallback<T> {

    T createWidget(Checkbox checkbox);
}
