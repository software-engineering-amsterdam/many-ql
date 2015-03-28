package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StaticFields implements Iterable<AbstractStaticFormField> {
    private final List<AbstractStaticFormField> staticFormFields;

    public void addStaticField(AbstractStaticFormField staticFieldElement) {
        staticFormFields.add(staticFieldElement);
    }

    public ITypeDescriptor getTypeOfField(String identifier) {
        for (AbstractStaticFormField staticFormField : staticFormFields) {
            final String iteratedVariableName = staticFormField.getVariable();
            if (iteratedVariableName.equals(identifier)) {
                return staticFormField.getTypeDescriptor();
            }
        }
        throw new FieldNotFoundException(identifier);
    }

    public String getLabelForField(String identifier) {
        for(AbstractStaticFormField field : staticFormFields){
            final String iteratedVariableName = field.getVariable();
            if (iteratedVariableName.equals(identifier)){
                return field.getLabel();
            }
        }
        throw new FieldNotFoundException(identifier);
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
            final String iteratedVariableName = staticFormField.getVariable();
            if (iteratedVariableName.equals(variableName)) {
                return true;
            }
        }
        return false;
    }
}
