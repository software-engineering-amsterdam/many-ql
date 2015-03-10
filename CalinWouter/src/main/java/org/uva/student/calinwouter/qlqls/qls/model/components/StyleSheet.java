package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class StyleSheet {
    private final String styleSheetName;
    private final Pages pages;
    private final Defaults defaults;

    private static Map<String, Object> createBoolDefaults() {
        return null; // TODO
    }

    private static Map<String, Object> createIntDefaults() {
        return null; // TODO
    }

    private static Map<String, Object> createStringDefaults() {
        return null; // TODO
    }

    private static Map<TypeDescriptor, Map<String, Object>> createDefaultStylingSettings() {
        Map<TypeDescriptor, Map<String, Object>> defaultStylingSettings = new HashMap<TypeDescriptor, Map<String, Object>>();
        defaultStylingSettings.put(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR, createBoolDefaults());
        defaultStylingSettings.put(IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR, createIntDefaults());
        defaultStylingSettings.put(StringValue.STRING_VALUE_TYPE_DESCRIPTOR, createStringDefaults());
        return defaultStylingSettings;
    }

    private static Defaults createDefaultFallbacks(Defaults d) {
        Map<TypeDescriptor, Map<String, Object>> defaultStyleSheetSettings = new HashMap<TypeDescriptor, Map<String, Object>>();
        defaultStyleSheetSettings.putAll(createDefaultStylingSettings());
        defaultStyleSheetSettings.putAll(d.getDefaultStyleSheetSettings());
        return new Defaults(defaultStyleSheetSettings);
    }

    public StyleSheet(String ident, Page... pages) {
        this(ident, new Pages(pages), createDefaultFallbacks(new Defaults(new HashMap<TypeDescriptor, Map<String, Object>>())));
    }

    /**
     * Find the styling settings for the specified field for the specified type.
     */
    public Map<String, Object> findFieldStylingSettings(final String ident, final TypeDescriptor type) throws FieldNotFoundException {
        return defaults.createNewStylingSettingsMapUsingOverriding(type, pages.findFieldStylingSettings(ident, type));
    }
}
