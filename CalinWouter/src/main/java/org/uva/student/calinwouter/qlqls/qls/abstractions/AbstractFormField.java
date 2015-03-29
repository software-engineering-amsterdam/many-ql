package org.uva.student.calinwouter.qlqls.qls.abstractions;

import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * ResultingFieldsCollection fields are either questions or computed values, always consisting of an identifier and a set of
 * styling arguments.
 */
public abstract class AbstractFormField {
    protected final String identifier;
    protected final Map<String, Object> stylingArguments;

    public AbstractFormField(String identifier, Map<String, Object> stylingArguments) {
        this.identifier = identifier;
        this.stylingArguments = stylingArguments;
    }

    public AbstractFormField(String identifier) {
        this(identifier, new HashMap<String, Object>());
    }

    public Map<String, Object> deriveStylingSettingsMap(FieldType fieldType) {
        final String fieldName = fieldType.getFieldName();
        if (identifier.equals(fieldName)) {
            return new HashMap<String, Object>(stylingArguments);
        }
        return null;
    }

    public String collectFieldName() {
        return identifier;
    }

    public abstract Component render(QLSRenderParameters qlsRenderParameters);
}
