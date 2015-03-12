package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.ComboWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.RadioWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.SliderWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.SpinboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;
import org.uva.student.calinwouter.qlqls.qls.model.components.*;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.*;

/**
 * This class is used to fetch the right widget based on the QLS widget settings.
 */
public class QLSWidgetFetcher implements IQuestionWidgetCallback<IWidget> {
    private final Question question;
    private final FormInterpreter formInterpreter;
    private final StylingSettings stylingSettings;

    private IWidget createLabelWithWidgetWidget(IWidget embeddedWidget) {
        return new LabelWithWidgetWidget(question, stylingSettings, embeddedWidget, formInterpreter);
    }

    @Override
    public IWidget createWidget(Checkbox checkbox) {
        return createLabelWithWidgetWidget(new CheckboxWidget(question, formInterpreter));
    }

    @Override
    public IWidget createWidget(Radio radio) {
        return createLabelWithWidgetWidget(new RadioWidget(question, formInterpreter, radio));
    }

    @Override
    public IWidget createWidget(Slider slider) {
        return createLabelWithWidgetWidget(new SliderWidget(question, formInterpreter, slider));
    }

    @Override
    public IWidget createWidget(Spinbox spinbox) {
        return createLabelWithWidgetWidget(new SpinboxWidget(question, formInterpreter));
    }

    @Override
    public IWidget createWidget(Textbox textbox) {
        return createLabelWithWidgetWidget(new TextboxWidget(question, formInterpreter));
    }

    @Override
    public IWidget createWidget(Combo combo) {
        return createLabelWithWidgetWidget(new ComboWidget(question, formInterpreter, combo));
    }

    @Override
    public IWidget createWidget(Intbox intbox) {
        return createLabelWithWidgetWidget(new IntboxWidget(question, formInterpreter));
    }

    public QLSWidgetFetcher(FormInterpreter formInterpreter, Question question,
                            StylingSettings stylingSettings) {
        this.formInterpreter = formInterpreter;
        this.question = question;
        this.stylingSettings = stylingSettings;
    }
}
