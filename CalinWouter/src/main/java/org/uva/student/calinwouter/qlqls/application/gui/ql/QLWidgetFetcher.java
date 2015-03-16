package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.VariableTableWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticQuestionField;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

public class QLWidgetFetcher implements TypeCallback{
    private final QLInterpreter qlIntepreter;
    private final StaticQuestionField staticQuestionField;
    private IWidget widget;
    private VariableTableWrapper variableTableWrapper;
    private QLGUI qlgui;

    private void createLabelWithWidgetWidget(IWidget embeddedWidget) {
        widget = new LabelWithWidgetWidget(staticQuestionField.getLabel(), staticQuestionField.getVariable(), null, embeddedWidget, variableTableWrapper, qlgui);
    }

    public void createWidget(TypeDescriptor typeDescriptor) {
        typeDescriptor.callTypeMethod(this);
    }

    @Override
    public void usesBoolean() {
        createLabelWithWidgetWidget(new CheckboxWidget(staticQuestionField.getVariable(), qlIntepreter, variableTableWrapper));
    }

    @Override
    public void usesInteger() {
        createLabelWithWidgetWidget(new IntboxWidget(staticQuestionField.getVariable(),qlIntepreter, variableTableWrapper));
    }

    @Override
    public void usesString() {
        createLabelWithWidgetWidget(new TextboxWidget(staticQuestionField.getVariable(), qlIntepreter, variableTableWrapper));
    }

    public IWidget getWidget() {
        return widget;
    }

    public QLWidgetFetcher(QLInterpreter qlIntepreter, StaticQuestionField staticQuestionField, VariableTableWrapper variableTableWrapper, QLGUI qlgui) {
        this.qlIntepreter = qlIntepreter;
        this.staticQuestionField = staticQuestionField;
        this.variableTableWrapper = variableTableWrapper;
        this.qlgui = qlgui;
    }
}
