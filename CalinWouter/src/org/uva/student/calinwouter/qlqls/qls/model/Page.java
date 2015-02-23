package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.types.AbstractPushable;

import java.util.LinkedList;
import java.util.List;

public class Page extends AbstractModel<Page> {
    private String ident;
    private List<Section> sections;
    private List<Default> defaultSettings;

    public List<Section> getSections() {
        return sections;
    }

    public List<Default> getDefaultSettings() {
        return defaultSettings;
    }

    public String getPageName() {
        return ident;
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
    public void updateStates(HeadlessFormInterpreter headlessFormInterpreter, List<Default> defaultList) {
        for (Section section : sections) {
            section.updateStates(headlessFormInterpreter, defaultList);
        }
    }

    @Override
    public void apply(IModel iModel) {
        iModel.casePage(this);
    }

    public Page() {
        sections = new LinkedList<Section>();
        defaultSettings = new LinkedList<Default>();
        visible = false;
    }
}
