package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IQuestionWidgetCallback;

@Data
@AllArgsConstructor
public class Slider {
    private final Integer min;
    private final Integer max;
}
