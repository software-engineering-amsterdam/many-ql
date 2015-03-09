package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets.ComboWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.boolwidgets.RadioWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets.SliderWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.intwidgets.SpinboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.components.*;
import org.uva.student.calinwouter.qlqls.qls.model.components.Checkbox;

import java.awt.*;
import java.util.Map;

/**
 * This class is used to fetch the right widget based on the QLS widget settings.
 */
public class QLSWidgetFetcher implements IQuestionWidgetCallback, IWidget {
    private final Question question;
    private IWidget widget;
    private final HeadlessFormInterpreter headlessFormInterpreter;
    private final Map<String, Object> widgetSettings;

    @Override
    public void widgetIsCheckboxWidget(Checkbox checkbox) {
        widget = new LabelWithWidgetWidget(question, widgetSettings,
                new CheckboxWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void widgetIsRadioWidget(Radio radio) {
        widget = new LabelWithWidgetWidget(question, widgetSettings,
                new RadioWidget(question, headlessFormInterpreter, radio), headlessFormInterpreter);
    }

    @Override
    public void widgetIsSliderWidget(Slider slider) {
        widget = new LabelWithWidgetWidget(question, widgetSettings,
                new SliderWidget(question, headlessFormInterpreter, slider), headlessFormInterpreter);
    }

    @Override
    public void widgetIsSpinboxWidget(Spinbox spinbox) {
        widget = new LabelWithWidgetWidget(question, widgetSettings,
                new SpinboxWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void widgetIsTextboxWidget(Textbox textbox) {
        widget = new LabelWithWidgetWidget(question, widgetSettings,
                new TextboxWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void widgetIsIntboxWidget(Textbox textbox) {
        widget = new LabelWithWidgetWidget(question, widgetSettings,
                new TextboxWidget(question, headlessFormInterpreter), headlessFormInterpreter);
    }

    @Override
    public void widgetIsComboWidget(Combo combo) {
        widget = new LabelWithWidgetWidget(question, widgetSettings,
                new ComboWidget(question, headlessFormInterpreter, combo), headlessFormInterpreter);
    }

    @Override
    public Component getWidget() {
        return widget.getWidget();
    }

    public QLSWidgetFetcher(HeadlessFormInterpreter headlessFormInterpreter, Question question,
                            Map<String, Object> widgetSettings) {
        this.headlessFormInterpreter = headlessFormInterpreter;
        this.question = question;
        this.widgetSettings = widgetSettings;
    }
}
