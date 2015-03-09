package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;

@Data
@AllArgsConstructor
public class Radio extends AbstractWidget {
    private final String yesLbl;
    private final String noLbl;

    @Override
    public void applyWidget(final IQuestionWidgetCallback widgetCallback) {
        widgetCallback.widgetIsRadioWidget(this);
    }
}
