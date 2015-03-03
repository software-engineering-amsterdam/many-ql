package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractComponent;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.interfaces.IModel;
import org.uva.student.calinwouter.qlqls.qls.model.FieldWidget;

import java.lang.reflect.Field;
import java.util.*;

@Data
@AllArgsConstructor
public class Section {
    private final String ident;
    private final Fields fields;
    private final Defaults defaults;

    public Section(String ident, AbstractFormField... fields) {
        this(ident, new Fields(fields), new Defaults(new HashMap<TypeDescriptor, Map<String, Object>>()));
    }

    public Collection<FieldWidget> collectFieldWidgets() {
        return fields.collectFieldWidgets();
    }
}
