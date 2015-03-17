package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.StateWrapper;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.boolwidgets.CheckboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.intwidgets.IntboxWidget;
import org.uva.student.calinwouter.qlqls.application.gui.widgets.question.stringwidgets.TextboxWidget;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StaticQuestionField;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

/**
 * This class is used to fetch the right widget based on the type descriptor
 */
public class QLWidgetFetcher implements TypeCallback{
    private final QLInterpreter qlInterpreter;
    private final StaticQuestionField staticQuestionField;
    private final StateWrapper stateWrapper;
    private IWidget widget;

    private void createLabelWithWidgetWidget(IWidget embeddedWidget) {
        widget = new LabelWithWidgetWidget(staticQuestionField.getLabel(), staticQuestionField.getVariable(), null, embeddedWidget, stateWrapper);
    }

    public void createWidget(TypeDescriptor typeDescriptor) {
        typeDescriptor.callTypeMethod(this);
    }

    @Override
    public void usesBoolean() {
        createLabelWithWidgetWidget(new CheckboxWidget(staticQuestionField.getVariable(), qlInterpreter, stateWrapper));
    }

    @Override
    public void usesInteger() {
        createLabelWithWidgetWidget(new IntboxWidget(staticQuestionField.getVariable(), qlInterpreter, stateWrapper));
    }

    @Override
    public void usesString() {
        createLabelWithWidgetWidget(new TextboxWidget(staticQuestionField.getVariable(), qlInterpreter, stateWrapper));
    }

    public IWidget getWidget() {
        return widget;
    }

    public QLWidgetFetcher(QLInterpreter qlInterpreter, StaticQuestionField staticQuestionField, StateWrapper stateWrapper) {
        this.qlInterpreter = qlInterpreter;
        this.staticQuestionField = staticQuestionField;
        this.stateWrapper = stateWrapper;
    }
}
