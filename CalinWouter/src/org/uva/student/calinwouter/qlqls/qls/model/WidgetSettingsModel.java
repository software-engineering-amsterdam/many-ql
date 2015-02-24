package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;

import java.util.HashMap;
import java.util.Map;

public class WidgetSettingsModel {
    private AbstractWidget<?> widget;
    private String font;
    private Integer fontSize;
    private Integer color;

    private void applyIfSet(Object variable, Object value) {
        if (value != null) {
            variable = value;
        }
    }

    public static void newInstance(Map<String, Object> parentMap, Map<String, Object> childMap) {
        HashMap<String, Object> finalMap = new HashMap<String, Object>();
        for (Map.Entry<String, Object> parentEntry : parentMap.entrySet()) {
            finalMap.put(parentEntry.getKey(), parentEntry.getValue());
        }
        for (Map.Entry<String, Object> parentEntry : childMap.entrySet()) {
            if (parentEntry.getValue() != null) {
                finalMap.put(parentEntry.getKey(), parentEntry.getValue());
            }
        }
        return finalMap;
    }

    public WidgetSettingsModel(Map<String, Object> settingsMap) throws NoSuchFieldException, IllegalAccessException {
        for (Map.Entry<String, Object> setting : settingsMap.entrySet()) {
            WidgetSettingsModel.class.getField(setting.getKey()).set(this, settingsMap.get(setting.getKey()));
        }
    }

}
