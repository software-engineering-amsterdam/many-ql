package org.uva.student.calinwouter.qlqls.qls.abstractions;

import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;

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

    public abstract IWidget render(String identifier, QLSRenderParameters qlsRenderParameters);
}
