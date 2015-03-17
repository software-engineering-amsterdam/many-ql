package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StaticFields implements Iterable<AbstractStaticFormField> {
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
        throw new RuntimeException(new FieldNotFoundException());
    }

    public String getLabelForField(String ident) {
        for(AbstractStaticFormField field: staticFormFields){
            if(field.getVariable().equals(ident)){
                return field.getLabel();
            }
        }
        return null;
    }

    public StaticFields() {
        this.staticFormFields = new LinkedList<AbstractStaticFormField>();
    }

    @Override
    public Iterator<AbstractStaticFormField> iterator() {
        return staticFormFields.iterator();
    }

    public boolean containsField(String variableName) {
        for (AbstractStaticFormField staticFormField : staticFormFields) {
            if (staticFormField.getVariable().equals(variableName)) {
                return true;
            }
        }
        return false;
    }
}
