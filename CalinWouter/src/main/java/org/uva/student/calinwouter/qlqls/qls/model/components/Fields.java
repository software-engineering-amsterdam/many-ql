package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import java.util.*;

@Data
public class Fields {
    private final List<AbstractFormField> fields;

    public Fields(AbstractFormField... fields) {
        this.fields = Arrays.asList(fields);
    }

    protected Map<String, Object> findFieldStylingSettings(final String ident) throws FieldNotFoundException {
        for (AbstractFormField f : fields) {
            if (f.getIdent().equals(ident)) {
                return f.getStylingArguments();
            }
        }
        throw new FieldNotFoundException();
    }
}
