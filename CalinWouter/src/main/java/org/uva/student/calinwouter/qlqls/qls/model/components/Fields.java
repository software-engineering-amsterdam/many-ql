package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.FieldType;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Fields {
    private final List<AbstractFormField> fields;

    public Fields(AbstractFormField... fields) {
        this.fields = Arrays.asList(fields);
    }

    public Map<String, Object> deriveStylingSettingsMap(FieldType fieldType) {
        for (AbstractFormField field : fields) {
            final Map<String, Object> stylingSettings = field.deriveStylingSettingsMap(fieldType);
            if (stylingSettings != null) {
                return stylingSettings;
            }
        }
        return null;
    }

    public List<String> collectFields() {
        List<String> fieldNames = new LinkedList<String>();
        for (AbstractFormField abstractFormField : fields) {
            fieldNames.add(abstractFormField.collectFieldName());
        }
        return fieldNames;
    }

    public void render(JPanel sectionPanel) {
        for (AbstractFormField abstractFormField : fields) {
            final Component renderedComponent = abstractFormField.render();
            sectionPanel.add(renderedComponent);
        }
    }
}
