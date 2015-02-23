package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets.RadioWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets.SpinboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.qls.model.IQuestionWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.Question;

import java.awt.*;

public class QuestionWidgetFetcher implements IQuestionWidgetCallback, IWidget {
    private IWidget widget;

    @Override
    public void caseCheckboxWidget(Question question) {
        widget = new CheckboxWidget(question);
    }

    @Override
    public void caseRadioWidget(Question question) {
        widget = new RadioWidget(question);
    }

    @Override
    public void caseIntboxWidget(Question question) {
        widget = new IntboxWidget(question);
    }

    @Override
    public void caseSpinboxWidget(Question question) {
        widget = new SpinboxWidget(question);
    }

    @Override
    public void caseTextboxWidget(Question question) {
        widget = new TextboxWidget(question);
    }

    @Override
    public Component getWidget() {
        return widget.getWidget();
    }
}
