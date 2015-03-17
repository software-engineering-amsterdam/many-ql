package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import java.util.*;

public class Fields implements Iterable<AbstractFormField> {
    private final List<AbstractFormField> fields;

    public Fields(AbstractFormField... fields) {
        this.fields = Arrays.asList(fields);
    }

    @Override
    public Iterator<AbstractFormField> iterator() {
        return fields.iterator();
    }
}
