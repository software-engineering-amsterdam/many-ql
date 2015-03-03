package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;
import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IQuestionWidgetCallback;

// TODO really ugly construction!!!!
public class Question extends AbstractFormField<Question> implements TypeCallback {
    private IQuestionWidgetCallback widgetCallback;

    public void applyWidget(IQuestionWidgetCallback widgetCallback, TypeDescriptor<?> typeDescriptor) {
        this.widgetCallback = widgetCallback;
        typeDescriptor.callTypeMethod(this);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseQuestion(this);
    }

    public Question(QLSInterpreter qlsInterpreter) {
        super(qlsInterpreter);
    }

    @Override
    public void usesBoolean() {
        try {
            getTypeToWidgetSettingsModel().getWidgetSettingsModel(BoolValue.TYPE_REFERENCE).getWidget()
                    .applyWidget(this, widgetCallback, getWidgetSettingsModel(BoolValue.TYPE_REFERENCE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void usesInteger() {
        try {
            getTypeToWidgetSettingsModel().getWidgetSettingsModel(IntegerValue.TYPE_REFERENCE).getWidget()
                    .applyWidget(this, widgetCallback, getWidgetSettingsModel(IntegerValue.TYPE_REFERENCE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void usesString() {
        try {
            getTypeToWidgetSettingsModel().getWidgetSettingsModel(StringValue.TYPE_REFERENCE).getWidget()
                    .applyWidget(this, widgetCallback, getWidgetSettingsModel(StringValue.TYPE_REFERENCE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
