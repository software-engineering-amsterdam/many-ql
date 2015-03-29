package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Page {
    private final String identifier;
    private final Sections sections;
    private final Defaults defaults;

    public List<Defaults> collectAllDefaultsInstances() {
        final List<Defaults> collectedDefaults = new LinkedList<Defaults>();
        final List<Defaults> sectionDefaults = sections.collectAllDefaultsInstances();
        collectedDefaults.add(defaults);
        collectedDefaults.addAll(sectionDefaults);
        return sectionDefaults;
    }

    public Map<String, Object> deriveStylingSettingsMap(FieldType fieldType) {
        final Map<String, Object> settingsMap = new HashMap<String, Object>();
        final Map<String, Object> defaultStylingSettings = defaults.deriveStylingSettingsMap(fieldType);
        final Map<String, Object> pageStylingSettings = sections.deriveStylingSettingsMap(fieldType);
        settingsMap.putAll(defaultStylingSettings);
        if (pageStylingSettings == null) {
            return null;
        }
        settingsMap.putAll(pageStylingSettings);
        return settingsMap;
    }

    public Page(String identifier, Sections sections, Defaults defaults) {
        this.identifier = identifier;
        this.sections = sections;
        this.defaults = defaults;
    }

    public Page(String identifier, Section... sections) {
        this(identifier, new Sections(sections), new Defaults(new HashMap()));
    }

    public List<String> collectFields() {
        return sections.collectFields();
    }

    public void addAndRenderTab(JTabbedPane jTabbedPane) {
        jTabbedPane.addTab(identifier, sections.render());
    }
}
