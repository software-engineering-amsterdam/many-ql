package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.ComboWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.RadioWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.SliderWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.SpinboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;
import org.uva.student.calinwouter.qlqls.qls.model.components.*;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.*;

/**
 * This class is used to fetch the right widget based on the QLS widget settings.
 */
public class QLSWidgetFetcher implements IQuestionWidgetCallback<IWidget> {
    private final Question question;
    private final QLInterpreter qlIntepreter;
    private final VariableTableWrapper variableTableWrapper;
    private final StylingSettings stylingSettings;

    private IWidget createLabelWithWidgetWidget(IWidget embeddedWidget) {
        //TODO change this
        //return new LabelWithWidgetWidget(question.getIdent(), stylingSettings, embeddedWidget, variableTableWrapper);
        return null;
    }

    @Override
    public IWidget createWidget(Checkbox checkbox) {
        return createLabelWithWidgetWidget(new CheckboxWidget(question.getIdent(), qlIntepreter, variableTableWrapper));
    }

    @Override
    public IWidget createWidget(Radio radio) {
        return createLabelWithWidgetWidget(new RadioWidget(question, qlIntepreter, variableTableWrapper, radio));
    }

    @Override
    public IWidget createWidget(Slider slider) {
        return createLabelWithWidgetWidget(new SliderWidget(question, qlIntepreter, variableTableWrapper, slider));
    }

    @Override
    public IWidget createWidget(Spinbox spinbox) {
        return createLabelWithWidgetWidget(new SpinboxWidget(question, qlIntepreter, variableTableWrapper));
    }

    @Override
    public IWidget createWidget(Textbox textbox) {
        return createLabelWithWidgetWidget(new TextboxWidget(question.getIdent(), qlIntepreter, variableTableWrapper));
    }

    @Override
    public IWidget createWidget(Combo combo) {
        return createLabelWithWidgetWidget(new ComboWidget(question, qlIntepreter, variableTableWrapper, combo));
    }

    @Override
    public IWidget createWidget(Intbox intbox) {
        return createLabelWithWidgetWidget(new IntboxWidget(question.getIdent(), qlIntepreter, variableTableWrapper));
    }

    public QLSWidgetFetcher(QLInterpreter qlIntepreter, VariableTableWrapper variableTableWrapper, Question question,
                            StylingSettings stylingSettings) {
        this.qlIntepreter = qlIntepreter;
        this.variableTableWrapper = variableTableWrapper;
        this.question = question;
        this.stylingSettings = stylingSettings;
    }
}
