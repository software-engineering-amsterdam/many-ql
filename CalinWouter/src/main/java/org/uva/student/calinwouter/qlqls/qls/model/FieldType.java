package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

/**
 * This model is used for storing the relation of a field to its type descriptor.
 */
public class FieldType {
    private final String fieldName;
    private final ITypeDescriptor typeDescriptor;

    public String getFieldName() {
        return fieldName;
    }

    public ITypeDescriptor getTypeDescriptor() {
        return typeDescriptor;
    }

    public FieldType(String fieldName, ITypeDescriptor typeDescriptor) {
        this.fieldName = fieldName;
        this.typeDescriptor = typeDescriptor;
    }
}
