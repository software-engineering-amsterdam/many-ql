package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.ComputedValueWidgetFetcher;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.QuestionWidgetFetcher;
import org.uva.student.calinwouter.qlqls.qls.model.ComputedValue;
import org.uva.student.calinwouter.qlqls.qls.model.Question;

import java.awt.*;

public class FieldRenderer extends AbstractRenderer {
    private Component fieldComponent;

    @Override
    public void caseQuestion(Question question) {
        QuestionWidgetFetcher w = new QuestionWidgetFetcher();
        question.applyWidget(w);
        this.fieldComponent = w.getWidget();
    }

    @Override
    public void caseComputedValue(ComputedValue computedValue) {
        ComputedValueWidgetFetcher c = new ComputedValueWidgetFetcher();
        computedValue.applyWidget(c);
        this.fieldComponent = c.getWidget();
    }

    public Component getFieldComponent() {
        return fieldComponent;
    }
}
