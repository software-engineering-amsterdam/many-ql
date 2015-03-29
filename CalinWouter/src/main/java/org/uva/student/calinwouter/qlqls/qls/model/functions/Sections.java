package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Sections {
    private final List<Section> sections;

    public Map<String, Object> deriveStylingSettingsMap(FieldType fieldType) {
        for (Section section : sections) {
            Map<String, Object> pageStylingSettings = section.deriveStylingSettingsMap(fieldType);
            if (pageStylingSettings != null) {
                return pageStylingSettings;
            }
        }
        return null;
    }

    public List<String> collectFields() {
        final List<String> fieldNames = new LinkedList<String>();
        for (Section section : sections) {
            final List<String> sectionFieldNames = section.collectFields();
            fieldNames.addAll(sectionFieldNames);
        }
        return fieldNames;
    }

    public List<Defaults> collectAllDefaultsInstances() {
        final List<Defaults> defaultsList = new LinkedList<Defaults>();
        for (Section section : sections) {
            final Defaults sectionDefaults = section.collectDefaultsInstance();
            defaultsList.add(sectionDefaults);
        }
        return defaultsList;
    }

    public Component render(QLSRenderParameters qlsRenderParameters) {
        JPanel pagePanel = new JPanel();
        for (Section section : sections) {
            final Component renderedComponent = section.render(qlsRenderParameters);
            pagePanel.add(renderedComponent);
        }
        return pagePanel;
    }

    public Sections(Section... sections) {
        this.sections = Arrays.asList(sections);
    }
}
