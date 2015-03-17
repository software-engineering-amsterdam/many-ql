package org.uva.student.calinwouter.qlqls.application.gui.qls;

import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.ComboWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.RadioWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.SliderWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.SpinboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.*;

/**
 * This class is used to fetch the right widget based on the QLS widget settings.
 */
public class QLSWidgetFetcher implements IQuestionWidgetCallback<IWidget> {
    private final String questionIdentifier;
    private final QLInterpreter qlInterpreter;
    private final VariableTableWrapper variableTableWrapper;
    private final StylingSettings stylingSettings;
    private final StaticFields staticFields;

    private IWidget createLabelWithWidgetWidget(IWidget embeddedWidget) {
        return new LabelWithWidgetWidget(staticFields.getLabelForField(questionIdentifier), questionIdentifier, stylingSettings, embeddedWidget, variableTableWrapper);

    }

    @Override
    public IWidget createWidget(Checkbox checkbox) {
        return createLabelWithWidgetWidget(new CheckboxWidget(questionIdentifier, qlInterpreter, variableTableWrapper));
    }

    @Override
    public IWidget createWidget(Radio radio) {
        return createLabelWithWidgetWidget(new RadioWidget(questionIdentifier, qlInterpreter, variableTableWrapper, radio));
    }

    @Override
    public IWidget createWidget(Slider slider) {
        return createLabelWithWidgetWidget(new SliderWidget(questionIdentifier, qlInterpreter, variableTableWrapper, slider));
    }

    @Override
    public IWidget createWidget(Spinbox spinbox) {
        return createLabelWithWidgetWidget(new SpinboxWidget(questionIdentifier, qlInterpreter, variableTableWrapper));
    }

    @Override
    public IWidget createWidget(Textbox textbox) {
        return createLabelWithWidgetWidget(new TextboxWidget(questionIdentifier, qlInterpreter, variableTableWrapper));
    }

    @Override
    public IWidget createWidget(Combo combo) {
        return createLabelWithWidgetWidget(new ComboWidget(questionIdentifier, qlInterpreter, variableTableWrapper, combo));
    }

    @Override
    public IWidget createWidget(Intbox intbox) {
        return createLabelWithWidgetWidget(new IntboxWidget(questionIdentifier, qlInterpreter, variableTableWrapper));
    }

    public QLSWidgetFetcher(QLInterpreter qlInterpreter, VariableTableWrapper variableTableWrapper, String questionIdentifier,
                            StylingSettings stylingSettings, StaticFields staticFields) {
        this.qlInterpreter = qlInterpreter;
        this.variableTableWrapper = variableTableWrapper;
        this.questionIdentifier = questionIdentifier;
        this.stylingSettings = stylingSettings;
        this.staticFields = staticFields;
    }
}
