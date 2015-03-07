package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;

@Data
@AllArgsConstructor
public class Radio {
    private final String yesLbl;
    private final String noLbl;
}
