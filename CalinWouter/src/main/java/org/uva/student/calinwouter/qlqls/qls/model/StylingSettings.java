package org.uva.student.calinwouter.qlqls.qls.model;

import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.Checkbox;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.Intbox;
import org.uva.student.calinwouter.qlqls.qls.model.components.widgets.Textbox;

import java.util.HashMap;
import java.util.Map;

/**
 * This model contains all styling settings for a (default) type.
 */
@Data
public class StylingSettings {
    private final AbstractWidget widget;
    private final String font;
    private final int fontSize, color, width;

    public AbstractWidget getWidget() {
        return widget;
    }

    /**
     * This internal class is used for setting the default widget settings based on its type.
     */
    private class DefaultStylingSettingsCreator implements ITypeCallback {
        private final Map<String, Object> stylingSettings = new HashMap<String, Object>();

        @Override
        public void usesBoolean() {
            stylingSettings.put("widget", new Checkbox());
        }

        @Override
        public void usesInteger() {
            stylingSettings.put("widget", new Intbox());
        }

        @Override
        public void usesString() {
            stylingSettings.put("widget", new Textbox());
        }

        public Map<String, Object> getResults() {
            stylingSettings.put("font", "Arial");
            stylingSettings.put("fontSize", 12);
            stylingSettings.put("color", 0);
            stylingSettings.put("width", 200);
            return stylingSettings;
        }
    }

    /**
     * Create a map based on the provided styling settings, with fallback parameters to the defaults.
     */
    private Map<String, Object> createMapBackedByDefaults(ITypeDescriptor typeDescriptor, Map<String, Object> stylingSettingsMap) {
        DefaultStylingSettingsCreator defaultStylingSettingsCreator = new DefaultStylingSettingsCreator();

        // When no typeDescriptor is set, it is not attached to a type, thus do not set the default widget.
        if (typeDescriptor != null) {
            typeDescriptor.callTypeMethod(defaultStylingSettingsCreator);
        }
        Map<String, Object> newStylingSettingsMap =
                new HashMap<String, Object>(defaultStylingSettingsCreator.getResults());
        newStylingSettingsMap.putAll(stylingSettingsMap);
        return newStylingSettingsMap;
    }

    public StylingSettings(ITypeDescriptor typeDescriptor, Map<String, Object> stylingSettingsMap) {
        Map<String, Object> newStylingSettingsMap = createMapBackedByDefaults(typeDescriptor, stylingSettingsMap);
        this.widget = (AbstractWidget) newStylingSettingsMap.get("widget");
        this.font = (String) newStylingSettingsMap.get("font");
        this.fontSize = (Integer) newStylingSettingsMap.get("fontSize");
        this.color = (Integer) newStylingSettingsMap.get("color");
        this.width = (Integer) newStylingSettingsMap.get("width");
    }
}
