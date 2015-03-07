package org.uva.student.calinwouter.qlqls.qls.abstractions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.components.Question;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;

@Data
@AllArgsConstructor
public abstract class AbstractWidget extends AbstractModel implements TypeCallback {
    public abstract void applyWidget(Question question, IQuestionWidgetCallback widgetCallback, WidgetSettingsModel widgetSettingsModel);

    @Override
    public void usesBoolean() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void usesInteger() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void usesString() {
        throw new UnsupportedOperationException();
    }
}
