package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;

/**
 * This model is used for storing the relation between a widget and its type descriptor.
 */
public class WidgetType {
    private final AbstractWidget widget;
    private final ITypeDescriptor typeDescriptor;

    public String asAssignmentError() {
        return "Invalid default widget assignment error: " + widget + ", " + typeDescriptor;
    }

    public WidgetType(AbstractWidget widget, ITypeDescriptor typeDescriptor) {
        this.widget = widget;
        this.typeDescriptor = typeDescriptor;
    }
}
