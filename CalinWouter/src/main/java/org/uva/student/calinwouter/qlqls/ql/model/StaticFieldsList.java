package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StaticFieldsList {
    private final List<AbstractStaticFormField> staticFields;

    public void addStaticField(AbstractStaticFormField staticFieldElement) {
        staticFields.add(staticFieldElement);
    }

    public StaticFieldsList() {
        this.staticFields = new LinkedList<AbstractStaticFormField>();
    }

}
