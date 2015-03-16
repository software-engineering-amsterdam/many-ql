package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticQuestionField;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

public class QLWidgetFetcher implements TypeCallback{
    private final QLInterpreter qlIntepreter;
    private final QLGUI qlgui;
    private final StaticQuestionField staticQuestionField;
    private IWidget widget;
    private VariableTable symbolTable;

    private void createLabelWithWidgetWidget(IWidget embeddedWidget) {
        widget = new LabelWithWidgetWidget(staticQuestionField, null, embeddedWidget, qlIntepreter, qlgui);
    }

    public void createWidget(TypeDescriptor typeDescriptor) {
        typeDescriptor.callTypeMethod(this);
    }

    @Override
    public void usesBoolean() {
        createLabelWithWidgetWidget(new CheckboxWidget(staticQuestionField, qlIntepreter, symbolTable));
    }

    @Override
    public void usesInteger() {
        createLabelWithWidgetWidget(new IntboxWidget(staticQuestionField,qlIntepreter, symbolTable));
    }

    @Override
    public void usesString() {
        createLabelWithWidgetWidget(new TextboxWidget(staticQuestionField, qlIntepreter, symbolTable));
    }

    public IWidget getWidget() {
        return widget;
    }

    public QLWidgetFetcher(QLInterpreter qlIntepreter, StaticQuestionField staticQuestionField, QLGUI qlgui, VariableTable symbolTable) {
        this.qlIntepreter = qlIntepreter;
        this.qlgui = qlgui;
        this.staticQuestionField = staticQuestionField;
        this.symbolTable = symbolTable;
    }
}
