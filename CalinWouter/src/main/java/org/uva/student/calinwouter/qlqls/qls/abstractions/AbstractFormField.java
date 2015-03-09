package org.uva.student.calinwouter.qlqls.qls.abstractions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Form fields are either questions or computed values, always consisting of an identifier and a set of
 * styling arguments.
 */
@Data
@AllArgsConstructor
public abstract class AbstractFormField {
    protected final String ident;
    protected final Map<String, Object> stylingArguments;

    public AbstractFormField(String ident) {
        this(ident, new HashMap<String, Object>());
    }
}
