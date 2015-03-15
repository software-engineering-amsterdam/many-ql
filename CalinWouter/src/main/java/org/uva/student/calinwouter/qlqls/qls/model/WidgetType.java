package org.uva.student.calinwouter.qlqls.qls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;

/**
 * This model is used for storing the relation between a widget and its type descriptor.
 */
@Data
@AllArgsConstructor
public class WidgetType {
    private final AbstractWidget widget;
    private final TypeDescriptor typeDescriptor;
}
