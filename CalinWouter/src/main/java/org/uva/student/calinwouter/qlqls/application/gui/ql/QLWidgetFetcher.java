package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interpreter.QLIntepreter;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

import javax.swing.*;
import java.awt.*;

public class QLWidgetFetcher implements TypeCallback{
    private final QLIntepreter qlIntepreter;
    private final QLGUI qlgui;
    private final QuestionField questionField;
    private IWidget widget;

    private void createLabelWithWidgetWidget(IWidget embeddedWidget) {
        widget = new LabelWithWidgetWidget(questionField, null, embeddedWidget, qlIntepreter, qlgui);
    }

    public void createWidget(TypeDescriptor typeDescriptor) {
        typeDescriptor.callTypeMethod(this);
    }

    @Override
    public void usesBoolean() {
        createLabelWithWidgetWidget(new CheckboxWidget(questionField, qlIntepreter));
    }

    @Override
    public void usesInteger() {
        createLabelWithWidgetWidget(new IntboxWidget(questionField,qlIntepreter));
    }

    @Override
    public void usesString() {
        createLabelWithWidgetWidget(new TextboxWidget(questionField, qlIntepreter));
    }

    public IWidget getWidget() {
        return widget;
    }

    public QLWidgetFetcher(QLIntepreter qlIntepreter, QuestionField questionField, QLGUI qlgui) {
        this.qlIntepreter = qlIntepreter;
        this.qlgui = qlgui;
        this.questionField = questionField;
    }
}
