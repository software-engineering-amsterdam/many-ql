package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interpreter.QLIntepreter;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;

public class QLWidgetFetcher implements TypeCallback{
    private final QLIntepreter qlIntepreter;
    private final QLGUI qlgui;
    private final QuestionField questionField;
    private IWidget widget;
    private VariableTable symbolTable;

    private void createLabelWithWidgetWidget(IWidget embeddedWidget) {
        widget = new LabelWithWidgetWidget(questionField, null, embeddedWidget, qlIntepreter, qlgui);
    }

    public void createWidget(TypeDescriptor typeDescriptor) {
        typeDescriptor.callTypeMethod(this);
    }

    @Override
    public void usesBoolean() {
        createLabelWithWidgetWidget(new CheckboxWidget(questionField, qlIntepreter, symbolTable));
    }

    @Override
    public void usesInteger() {
        createLabelWithWidgetWidget(new IntboxWidget(questionField,qlIntepreter, symbolTable));
    }

    @Override
    public void usesString() {
        createLabelWithWidgetWidget(new TextboxWidget(questionField, qlIntepreter, symbolTable));
    }

    public IWidget getWidget() {
        return widget;
    }

    public QLWidgetFetcher(QLIntepreter qlIntepreter, QuestionField questionField, QLGUI qlgui, VariableTable symbolTable) {
        this.qlIntepreter = qlIntepreter;
        this.qlgui = qlgui;
        this.questionField = questionField;
        this.symbolTable = symbolTable;
    }
}
