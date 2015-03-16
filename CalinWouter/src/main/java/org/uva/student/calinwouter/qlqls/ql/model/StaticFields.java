package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import java.util.LinkedList;
import java.util.List;

public class StaticFields {
    private final List<AbstractStaticFormField> staticFormFields;

    public void addStaticField(AbstractStaticFormField staticFieldElement) {
        staticFormFields.add(staticFieldElement);
    }

    public List<AbstractStaticFormField> getStaticFormFields() {
        return staticFormFields;
    }

    public TypeDescriptor getTypeOfField(String ident) {
        for (AbstractStaticFormField staticFormField : staticFormFields) {
            if (staticFormField.getVariable().equals(ident)) {
                return staticFormField.getTypeDescriptor();
            }
        }
        throw new RuntimeException(new FieldNotFoundException());
    }

    public StaticFields() {
        this.staticFormFields = new LinkedList<AbstractStaticFormField>();
    }
}
