package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.model.functions.widgets.Checkbox;
import org.uva.student.calinwouter.qlqls.qls.model.functions.widgets.Intbox;
import org.uva.student.calinwouter.qlqls.qls.model.functions.widgets.Textbox;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This model contains all styling settings for a (default) type.
 */
public class StylingSettings {
    public static final String WIDGET = "widget";
    public static final String FONT = "font";
    public static final String FONT_SIZE = "fontSize";
    public static final String COLOR = "color";
    public static final String WIDTH = "width";

    private final AbstractWidget widget;
    private final String font;
    private final Integer fontSize, color, width;

    public Font createFont() {
        return new Font(font, 0, fontSize);
    }

    public AbstractWidget getWidget() {
        return widget;
    }

    public Color createForegroundColor() {
        return new Color(color);
    }

    public Dimension createSizeDimension(int oldHeight) {
        return new Dimension(width, oldHeight);
    }

    /**
     * This internal class is used for setting the default widget settings based on its type.
     */
    private class DefaultStylingSettingsCreator implements ITypeCallback {
        private final Map<String, Object> stylingSettings = new HashMap<String, Object>();

        public void usesBoolean() {
            stylingSettings.put(StylingSettings.WIDGET, new Checkbox());
        }

        public void usesInteger() {
            stylingSettings.put(StylingSettings.WIDGET, new Intbox());
        }

        public void usesString() {
            stylingSettings.put(StylingSettings.WIDGET, new Textbox());
        }

        public Map<String, Object> getResults() {
            stylingSettings.put(StylingSettings.FONT, "Arial");
            stylingSettings.put(StylingSettings.FONT_SIZE, 12);
            stylingSettings.put(StylingSettings.COLOR, 0);
            stylingSettings.put(StylingSettings.WIDTH, 200);
            return stylingSettings;
        }
    }

    /**
     * Create a map based on the provided styling settings, with fallback parameters to the defaults.
     */
    private Map<String, Object> createMapBackedByDefaults(ITypeDescriptor typeDescriptor, Map<String, Object> stylingSettingsMap) {
        DefaultStylingSettingsCreator defaultStylingSettingsCreator = new DefaultStylingSettingsCreator();

        // When no typeDescriptor is set, it is not attached to a type, thus do not set the default widget.
        if (typeDescriptor != null) { // TODO
            typeDescriptor.callTypeMethod(defaultStylingSettingsCreator);
        }
        Map<String, Object> newStylingSettingsMap =
                new HashMap<String, Object>(defaultStylingSettingsCreator.getResults());
        newStylingSettingsMap.putAll(stylingSettingsMap);
        return newStylingSettingsMap;
    }

    public StylingSettings(ITypeDescriptor typeDescriptor, Map<String, Object> stylingSettingsMap) {
        Map<String, Object> newStylingSettingsMap = createMapBackedByDefaults(typeDescriptor, stylingSettingsMap);
        this.widget = (AbstractWidget) newStylingSettingsMap.get(StylingSettings.WIDGET);
        this.font = (String) newStylingSettingsMap.get(StylingSettings.FONT);
        this.fontSize = (Integer) newStylingSettingsMap.get(StylingSettings.FONT_SIZE);
        this.color = (Integer) newStylingSettingsMap.get(StylingSettings.COLOR);
        this.width = (Integer) newStylingSettingsMap.get(StylingSettings.WIDTH);
    }
}
