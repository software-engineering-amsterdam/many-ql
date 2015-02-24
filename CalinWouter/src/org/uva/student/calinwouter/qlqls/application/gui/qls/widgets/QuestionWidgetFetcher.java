package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets.ComboboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets.RadioWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets.SliderWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets.SpinboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.textwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;

import java.awt.*;

public class QuestionWidgetFetcher implements IQuestionWidgetCallback, IWidget {
    private IWidget widget;
    private HeadlessFormInterpreter headlessFormInterpreter;
    private FormTypeChecker formTypeChecker;

    @Override
    public void caseCheckboxWidget(Question question, WidgetSettingsModel widgetSettingsModel) {
        widget = new LabelWithWidgetWidget(question, widgetSettingsModel,
                new CheckboxWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void caseComboboxWidget(Question question, WidgetSettingsModel widgetSettingsModel) {
        widget = new LabelWithWidgetWidget(question, widgetSettingsModel,
                new ComboboxWidget(question,headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void caseRadioWidget(Question question, WidgetSettingsModel widgetSettingsModel) {
        widget = new LabelWithWidgetWidget(question, widgetSettingsModel,
                new RadioWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void caseSliderWidget(Question question, WidgetSettingsModel widgetSettingsModel) {
        widget = new LabelWithWidgetWidget(question, widgetSettingsModel,
                new SliderWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void caseSpinboxWidget(Question question, WidgetSettingsModel widgetSettingsModel) {
        widget = new LabelWithWidgetWidget(question, widgetSettingsModel,
                new SpinboxWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void caseTextboxWidget(Question question, WidgetSettingsModel widgetSettingsModel) {
        widget = new LabelWithWidgetWidget(question, widgetSettingsModel,
                new TextboxWidget(question, headlessFormInterpreter, formTypeChecker.getTypeDescriptor(question.getFieldName())),
                headlessFormInterpreter);
    }

    @Override
    public Component getWidget() {
        return widget.getWidget();
    }

    public QuestionWidgetFetcher(HeadlessFormInterpreter headlessFormInterpreter, FormTypeChecker formTypeChecker) {
        this.headlessFormInterpreter = headlessFormInterpreter;
        this.formTypeChecker = formTypeChecker;
    }
}
