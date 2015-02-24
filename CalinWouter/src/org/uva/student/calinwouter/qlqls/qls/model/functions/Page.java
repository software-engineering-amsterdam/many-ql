package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractComponent;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

import java.util.LinkedList;
import java.util.List;

public class Page extends AbstractComponent<Page> {
    private String ident;
    private List<Section> sections;
    private List<Default> defaultSettings;
    private int arg;

    public List<Default> getDefaultSettings() {
        return defaultSettings;
    }

    public String getPageName() {
        return ident;
    }

    @Override
    public void caseString(String string) {
        if (arg != 0) {
            super.caseString(string);
            return;
        }
        this.ident = string;
        arg++;
    }

    @Override
    public void caseDefault(Default defaultSetting) {
        defaultSettings.add(defaultSetting);
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public void caseSection(Section section) {
        sections.add(section);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.casePage(this);
    }

    public Page() {
        sections = new LinkedList<Section>();
        defaultSettings = new LinkedList<Default>();
    }
}
