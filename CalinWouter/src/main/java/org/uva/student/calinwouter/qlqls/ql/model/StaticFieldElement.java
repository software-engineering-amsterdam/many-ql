package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

public class StaticFieldElement {

    private final String label;

    private final String variable;

    private final TypeDescriptor typeDescriptor;

    public StaticFieldElement(String label, String variable, TypeDescriptor typeDescriptor) {
        this.label = label;
        this.variable = variable;
        this.typeDescriptor = typeDescriptor;
    }

}
