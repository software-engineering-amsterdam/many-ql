package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;

import java.util.Map;

public class Question extends AbstractFormField {

    public Question(String ident) {
        super(ident);
    }

    public Question(String ident, Map<String, Object> stylingArguments) {
        super(ident, stylingArguments);
    }

}
