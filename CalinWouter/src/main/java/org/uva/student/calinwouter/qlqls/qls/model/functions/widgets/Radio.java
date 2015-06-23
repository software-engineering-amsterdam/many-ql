package org.uva.student.calinwouter.qlqls.qls.model.functions.widgets;

import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.widgets.question.boolwidgets.RadioWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;

public class Radio extends AbstractWidget {
    private final String yesLabel;
    private final String noLabel;

    public Radio(String yesLabel, String noLabel) {
        this.yesLabel = yesLabel;
        this.noLabel = noLabel;
    }

    @Override
    public <T> T createWidget(IQuestionWidgetCallback<T> widgetCallback) {
        return widgetCallback.createWidget(this);
    }

    @Override
    public IWidget render(String identifier, QLSRenderParameters qlsRenderParameters) {
        final QLInterpreter qlInterpreter = qlsRenderParameters.getQlInterpreter();
        final StateWrapper stateWrapper = qlsRenderParameters.getStateWrapper();
        return new RadioWidget(identifier, qlInterpreter, stateWrapper, yesLabel, noLabel);
    }

    @Override
    public Boolean allowsBooleanValue() {
        return true;
    }
}
