package org.uva.student.calinwouter.qlqls.qls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

/**
 * This model is used for storing the relation of a field to its type descriptor.
 */
@Data
@AllArgsConstructor
public class FieldType {
    private final String fieldName;
    private final ITypeDescriptor typeDescriptor;
}
