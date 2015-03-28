package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;

import java.util.*;

@Data
@AllArgsConstructor
public class Section {
    private final String sectionName;
    private final Fields fields;
    private final Defaults defaults;

    public Section(String sectionName, AbstractFormField... fields) {
        this(sectionName, new Fields(fields), new Defaults(new HashMap<ITypeDescriptor, Map<String, Object>>()));
    }
}
