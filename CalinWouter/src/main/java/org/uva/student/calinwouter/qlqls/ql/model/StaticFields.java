package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StaticFields {
    private final List<AbstractStaticFormField> staticFormFields;

    public void addStaticField(AbstractStaticFormField staticFieldElement) {
        staticFormFields.add(staticFieldElement);
    }

    public TypeDescriptor getTypeOfField(String ident) {
        for (AbstractStaticFormField staticFormField : staticFormFields) {
            if (staticFormField.getVariable().equals(ident)) {
                return staticFormField.getTypeDescriptor();
            }
        }
    }

    public StaticFields() {
        this.staticFormFields = new LinkedList<AbstractStaticFormField>();
    }

}
