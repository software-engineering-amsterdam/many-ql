package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractWidget;

import java.util.HashMap;
import java.util.Map;

/**
 * This model is used for storing the (default) widget styling settings.
 */
public class WidgetSettingsModel {
    private final Map<String, Object> settingsMap;
    private AbstractWidget<?> widget;
    private String font;
    private Integer fontSize;
    private Integer width;
    private Integer color;

    public AbstractWidget<?> getWidget() {
        return widget;
    }

    public String getFont() {
        return font;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public Integer getColor() {
        return color;
    }

    public Integer getWidth() {
        return width;
    }

    /**
     * Combine the parent map and the child map, where the child map overrides the parent map.
     */
    public static WidgetSettingsModel combineSettingsModels(Map<String, Object> parentMap,
                                                                Map<String, Object> childMap)
            throws NoSuchFieldException, IllegalAccessException {
        HashMap<String, Object> finalMap = new HashMap<String, Object>(parentMap);
        for (Map.Entry<String, Object> parentEntry : childMap.entrySet()) {
            if (parentEntry.getValue() != null) {
                finalMap.put(parentEntry.getKey(), parentEntry.getValue());
            }
        }
        return new WidgetSettingsModel(finalMap);
    }

    /**
     * Combine the parent map and the child map, where the child map overrides the parent map.
     */
    public static WidgetSettingsModel combineSettingsModels(WidgetSettingsModel parentWidgetSettingsModel,
                                                            WidgetSettingsModel childWidgetSettingsModel)
            throws NoSuchFieldException, IllegalAccessException {
        return combineSettingsModels(parentWidgetSettingsModel.settingsMap, childWidgetSettingsModel.settingsMap);
    }

    /**
     * Based on the provided map, dynamically set the fields in the model.
     */
    public WidgetSettingsModel(Map<String, Object> settingsMap) throws NoSuchFieldException, IllegalAccessException {
        this.settingsMap = settingsMap;
        for (Map.Entry<String, Object> setting : settingsMap.entrySet()) {
            WidgetSettingsModel.class.getDeclaredField(setting.getKey()).set(this, settingsMap.get(setting.getKey()));
        }
    }

    private static HashMap<String, Object> createSettingsMap(AbstractWidget<?> widget, String font, Integer fontSize, Integer color, Integer width) {
        HashMap<String, Object> settingsMap = new HashMap<String, Object>();
        settingsMap.put("widget", widget);
        settingsMap.put("font", font);
        settingsMap.put("fontSize", fontSize);
        settingsMap.put("color", color);
        settingsMap.put("width", width);
        return settingsMap;
    }

    public WidgetSettingsModel(AbstractWidget<?> widget, String font, Integer fontSize, Integer color, Integer width)
            throws NoSuchFieldException, IllegalAccessException {
        this(createSettingsMap(widget, font, fontSize, color, width));
    }

}
