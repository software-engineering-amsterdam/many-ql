package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets.RadioWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets.SpinboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Question;

import java.awt.*;

public class QuestionWidgetFetcher implements IQuestionWidgetCallback, IWidget {
    private IWidget widget;
    private HeadlessFormInterpreter headlessFormInterpreter;

    @Override
    public void caseCheckboxWidget(Question question) {
        widget = new LabelWithWidgetWidget(question,
                new CheckboxWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void caseRadioWidget(Question question) {
        widget = new LabelWithWidgetWidget(question,
                new RadioWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void caseIntboxWidget(Question question) {
        widget = new LabelWithWidgetWidget(question,
                new IntboxWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void caseSpinboxWidget(Question question) {
        widget = new LabelWithWidgetWidget(question,
                new SpinboxWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void caseTextboxWidget(Question question) {
        widget = new LabelWithWidgetWidget(question,
                new TextboxWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public Component getWidget() {
        return widget.getWidget();
    }

    public QuestionWidgetFetcher(HeadlessFormInterpreter headlessFormInterpreter) {
        this.headlessFormInterpreter = headlessFormInterpreter;
    }
}
