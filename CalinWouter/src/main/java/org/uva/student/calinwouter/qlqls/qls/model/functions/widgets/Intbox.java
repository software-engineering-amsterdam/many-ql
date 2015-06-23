package org.uva.student.calinwouter.qlqls.qls.model.functions.widgets;

import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;

public class Intbox extends AbstractWidget {
    @Override
    public <T> T createWidget(IQuestionWidgetCallback<T> widgetCallback) {
        return widgetCallback.createWidget(this);
    }

    @Override
    public IWidget render(String identifier, QLSRenderParameters qlsRenderParameters) {
        final QLInterpreter qlInterpreter = qlsRenderParameters.getQlInterpreter();
        final StateWrapper stateWrapper = qlsRenderParameters.getStateWrapper();
        return new IntboxWidget(identifier, qlInterpreter, stateWrapper);
    }

    @Override
    public Boolean allowsIntegerValue() {
        return true;
    }
}
