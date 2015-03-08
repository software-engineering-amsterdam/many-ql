package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
public class Defaults {
    private final Map<TypeDescriptor, Map<String, Object>> defaultStyleSheetSettings;

    public Defaults(Map<TypeDescriptor, Map<String, Object>> defaultStyleSheetSettings) {
        this.defaultStyleSheetSettings = (Map<TypeDescriptor, Map<String, Object>>)
                Arrays.asList(defaultStyleSheetSettings);
    }

    /**
     * Return a new map that overrides the default values with the specified values.
     */
    public Map<String, Object> createNewStylingSettingsMapUsingOverriding(final TypeDescriptor type, final Map<String, Object> fieldStylingSettings) {
        Map<String, Object> newMap = new HashMap<String, Object>();
        newMap.putAll(defaultStyleSheetSettings.get(type));
        newMap.putAll(fieldStylingSettings);
        return newMap;
    }
}
