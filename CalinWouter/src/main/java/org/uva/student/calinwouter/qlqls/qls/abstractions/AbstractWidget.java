package org.uva.student.calinwouter.qlqls.qls.abstractions;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;

public abstract class AbstractWidget implements IAllowTypeChecker {
    public abstract <T> T createWidget(IQuestionWidgetCallback<T> widgetCallback);

    public Boolean allowsBooleanValue() {
        return false;
    }

    public Boolean allowsIntegerValue() {
        return false;
    }

    public Boolean allowsStringValue() {
        return false;
    }
}
