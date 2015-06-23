package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;

import javax.swing.*;
import java.util.*;

public class Pages {
    private final List<Page> pages;

    public Pages(Page... pages) {
        this.pages = Arrays.asList(pages);
    }

    public Iterator<Page> iterator() {
        return pages.iterator();
    }

    public List<Defaults> collectAllDefaultsInstances() {
        final List<Defaults> collectedDefaults = new LinkedList<Defaults>();
        for (final Page page : pages) {
            final List<Defaults> pageDefaults = page.collectAllDefaultsInstances();
            collectedDefaults.addAll(pageDefaults);
        }
        return collectedDefaults;
    }

    public Map<String, Object> deriveStylingSettingsMap(FieldType fieldType) {
        for (Page page : pages) {
            Map<String, Object> pageStylingSettings = page.deriveStylingSettingsMap(fieldType);
            if (pageStylingSettings != null) {
                return pageStylingSettings;
            }
        }
        return null;
    }

    public List<String> collectFields() {
        final List<String> fieldNames = new LinkedList<String>();
        for (Page page : pages) {
            final List<String> pageFieldNames = page.collectFields();
            fieldNames.addAll(pageFieldNames);
        }
        return fieldNames;
    }

    public void addAndRenderTabs(JTabbedPane jTabbedPane, QLSRenderParameters qlsRenderParameters) {
        for (Page page : pages) {
            page.addAndRenderTab(jTabbedPane, qlsRenderParameters);
        }
    }
}
