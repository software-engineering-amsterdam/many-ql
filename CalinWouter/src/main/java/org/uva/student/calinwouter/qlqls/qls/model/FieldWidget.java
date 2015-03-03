package org.uva.student.calinwouter.qlqls.qls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;

import java.util.Map;

/**
 * This model represents the usage of a field and refers to the widget being used.
 */
@Data
@AllArgsConstructor
public class FieldWidget {
    private final String fieldName;
    private final AbstractWidget widget;
    private final Map<String, Object> styleSheet;
}
