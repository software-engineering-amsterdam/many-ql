package org.uva.student.calinwouter.qlqls.qls.abstractions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;

@Data
@AllArgsConstructor
public abstract class AbstractWidget implements IAllowTypeChecker {
    public abstract <T> T createWidget(IQuestionWidgetCallback<T> widgetCallback);

    @Override
    public boolean allowsBooleanValue() {
        return false;
    }

    @Override
    public boolean allowsIntegerValue() {
        return false;
    }

    @Override
    public boolean allowsStringValue() {
        return false;
    }
}
