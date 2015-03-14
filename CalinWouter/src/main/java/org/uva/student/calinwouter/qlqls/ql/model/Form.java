package org.uva.student.calinwouter.qlqls.ql.model;


import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;

import java.util.LinkedList;
import java.util.List;

public class Form {
    private List<FormField> fields;

    public void addFormField(FormField field) {
        fields.add(field);
    }

    public List<FormField> getFields() {
        return fields;
    }

    public String getLabelForField(String fieldName) throws LabelNotAvailableException {
        for (FormField f : fields) {
            if (fieldName.equals(f.getVariable()))
                return f.getLabel();
        }
        throw new LabelNotAvailableException();
    }

    public boolean hasField(String fieldName) {
        for (FormField f: fields)
            if (fieldName.equals(f.getVariable()))
                return  true;
        return false;
    }

    public Form() {
        fields = new LinkedList<FormField>();
    }
}
