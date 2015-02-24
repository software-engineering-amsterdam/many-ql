package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.ComputedValueWidgetFetcher;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.QuestionWidgetFetcher;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.functions.ComputedValue;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

import java.awt.*;

public class FieldRenderer extends AbstractRenderer {
    private Component fieldComponent;
    private HeadlessFormInterpreter headlessFormInterpreter;

    @Override
    public void caseQuestion(Question question) {
        QuestionWidgetFetcher w = new QuestionWidgetFetcher(headlessFormInterpreter);
        question.applyWidget(w);
        this.fieldComponent = w.getWidget();
    }

    @Override
    public void caseComputedValue(ComputedValue computedValue) {
        ComputedValueWidgetFetcher c = new ComputedValueWidgetFetcher(headlessFormInterpreter);
        computedValue.applyWidget(c);
        this.fieldComponent = c.getWidget();
    }

    public Component getFieldComponent() {
        return fieldComponent;
    }

    public FieldRenderer(HeadlessFormInterpreter headlessFormInterpreter) {
        this.headlessFormInterpreter = headlessFormInterpreter;
    }
}
