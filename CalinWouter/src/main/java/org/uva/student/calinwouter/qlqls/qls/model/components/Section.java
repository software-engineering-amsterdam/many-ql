package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import java.util.*;

@Data
@AllArgsConstructor
public class Section {
    private final String sectionName;
    private final Fields fields;
    private final Defaults defaults;

    public Section(String sectionName, AbstractFormField... fields) {
        this(sectionName, new Fields(fields), new Defaults(new HashMap<TypeDescriptor, Map<String, Object>>()));
    }
}
