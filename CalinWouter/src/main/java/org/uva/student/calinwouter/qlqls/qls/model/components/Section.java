package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.FieldType;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Section {
    private final String sectionName;
    private final Fields fields;
    private final Defaults defaults;

    public Section(String sectionName, Fields fields, Defaults defaults) {
        this.sectionName = sectionName;
        this.fields = fields;
        this.defaults = defaults;
    }

    public Section(String sectionName, AbstractFormField... fields) {
        this(sectionName, new Fields(fields), new Defaults(new HashMap<ITypeDescriptor, Map<String, Object>>()));
    }

    public Map<String, Object> deriveStylingSettingsMap(FieldType fieldType) {
        final Map<String, Object> settingsMap = new HashMap<String, Object>();
        final Map<String, Object> defaultStylingSettings = defaults.deriveStylingSettingsMap(fieldType);
        final Map<String, Object> pageStylingSettings = fields.deriveStylingSettingsMap(fieldType);
        settingsMap.putAll(defaultStylingSettings);
        if (pageStylingSettings == null) {
            return null;
        }
        settingsMap.putAll(pageStylingSettings);
        return settingsMap;
    }

    public List<String> collectFields() {
        return fields.collectFields();
    }

    public Defaults collectDefaultsInstance() {
        return defaults;
    }

    public Component render() {
        final JPanel sectionPanel = new JPanel();
        final TitledBorder sectionBorder = BorderFactory.createTitledBorder(sectionName);
        sectionPanel.setBorder(sectionBorder);
        BoxLayout boxLayout = new BoxLayout(sectionPanel, BoxLayout.Y_AXIS);
        sectionPanel.setLayout(boxLayout);
        fields.render(sectionPanel);
        return sectionPanel;
    }
}
