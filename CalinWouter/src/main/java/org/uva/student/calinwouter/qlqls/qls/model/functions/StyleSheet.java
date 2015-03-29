package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StyleSheet {
    private final Pages pages;
    private final Defaults defaults;
    private String styleSheetName;

    /**
     * Derive the styling settings of a widget by overriding their settings in-depth.
     */
    public StylingSettings deriveStylingSettings(FieldType fieldType) {
        final Map<String, Object> settingsMap = new HashMap<String, Object>();
        final Map<String, Object> defaultStylingSettings = defaults.deriveStylingSettingsMap(fieldType);
        final Map<String, Object> pageStylingSettings = pages.deriveStylingSettingsMap(fieldType);
        settingsMap.putAll(defaultStylingSettings);
        if (pageStylingSettings == null) {
            final String fieldName = fieldType.getFieldName();
            throw new FieldNotFoundException(fieldName);
        }
        settingsMap.putAll(pageStylingSettings);
        return new StylingSettings(fieldType.getTypeDescriptor(), settingsMap);
    }

    public List<Defaults> collectAllDefaultsInstances() {
        final List<Defaults> defaultsList = new LinkedList<Defaults>();
        final List<Defaults> pagesDefaults = pages.collectAllDefaultsInstances();
        defaultsList.add(defaults);
        defaultsList.addAll(pagesDefaults);
        return defaultsList;
    }

    public List<String> collectFields() {
        return pages.collectFields();
    }

    public StyleSheet(String styleSheetName, Pages pages, Defaults defaults) {
        this.styleSheetName = styleSheetName;
        this.pages = pages;
        this.defaults = defaults;
    }

    public Component render(QLSRenderParameters qlsRenderParameters) {
        assert(qlsRenderParameters.getStyleSheet() == this);
        final JTabbedPane jTabbedPane = new JTabbedPane();
        pages.addAndRenderTabs(jTabbedPane, qlsRenderParameters);
        return jTabbedPane;
    }

    public String getStyleSheetName() {
        return styleSheetName;
    }

    @SuppressWarnings("unused") // Used through reflection.
    public StyleSheet(String styleSheetName, Page... pages) {
        this(styleSheetName, new Pages(pages), new Defaults(new HashMap<ITypeDescriptor, Map<String, Object>>()));
    }
}
