package org.uva.student.calinwouter.qlqls.ql.model;


import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;

import java.util.LinkedList;
import java.util.List;

public class ResultingFieldsCollection {
    private List<AbstractFormField> fields;

    public void addFormField(AbstractFormField field) {
        fields.add(field);
    }

    public List<AbstractFormField> getFields() {
        return fields;
    }

    public String getLabelForField(String fieldName) throws LabelNotAvailableException {
        for (AbstractFormField f : fields) {
            if (fieldName.equals(f.getVariable()))
                return f.getLabel();
        }
        throw new LabelNotAvailableException();
    }

    public boolean hasField(String fieldName) {
        for (AbstractFormField f: fields)
            if (fieldName.equals(f.getVariable()))
                return  true;
        return false;
    }

    public ResultingFieldsCollection() {
        fields = new LinkedList<AbstractFormField>();
    }
}
