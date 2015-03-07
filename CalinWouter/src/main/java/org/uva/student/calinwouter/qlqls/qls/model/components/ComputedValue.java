package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;

import java.util.Map;

public class ComputedValue extends AbstractFormField {

    public ComputedValue(String ident) {
        super(ident);
    }

    public ComputedValue(String ident, Map<String, Object> stylingArguments) {
        super(ident, stylingArguments);
    }

}