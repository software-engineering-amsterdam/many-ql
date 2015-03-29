package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;

import java.util.HashMap;
import java.util.Map;

public class Defaults {
    private final Map<ITypeDescriptor, Map<String, Object>> defaultStyleSheetSettings;

    // As this class is created through reflection, it cannot be instantiated using generics at this moment.
    @SuppressWarnings("unchecked")
    public Defaults(Map defaultStyleSheetSettings) {
        this.defaultStyleSheetSettings = (Map<ITypeDescriptor, Map<String, Object>>)
                defaultStyleSheetSettings;
    }

    public Map<String, Object> deriveStylingSettingsMap(FieldType fieldType) {
        final ITypeDescriptor fieldTypeDescriptor = fieldType.getTypeDescriptor();
        final Map<String, Object> stylingSettings = defaultStyleSheetSettings.get(fieldTypeDescriptor);
        if (stylingSettings == null) {
            return new HashMap<String, Object>();
        }
        return new HashMap<String, Object>(stylingSettings);
    }

    public AbstractWidget getWidget(ITypeDescriptor typeDescriptor) {
        Map<String, Object> typeDefaultSettings = defaultStyleSheetSettings.get(typeDescriptor);
        if (typeDefaultSettings == null) {
            return null;
        }
        return (AbstractWidget) typeDefaultSettings.get(StylingSettings.WIDGET);
    }
}
