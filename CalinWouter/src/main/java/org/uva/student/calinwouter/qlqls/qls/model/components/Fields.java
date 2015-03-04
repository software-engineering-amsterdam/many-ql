package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.FieldWidget;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Data
public class Fields {
    private final List<AbstractFormField> fields;

    public Fields(AbstractFormField... fields) {
        this.fields = Arrays.asList(fields);
    }

    public Collection<FieldWidget> collectFieldWidgets() {
        List<FieldWidget> fieldWidgets = new LinkedList<FieldWidget>();
        for (AbstractFormField field : fields) {
            fieldWidgets.add(field.collectFieldWidget());
        }
        return fieldWidgets;
    }
}
