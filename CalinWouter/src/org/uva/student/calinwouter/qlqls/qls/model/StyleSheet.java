package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;

import java.util.LinkedList;
import java.util.List;

public class StyleSheet extends AbstractModel<StyleSheet> {
    private List<Page> pages;
    private List<Default> defaultSettings;

    @Override
    public void caseDefault(Default defaultSetting) {
        defaultSettings.add(defaultSetting);
    }

    @Override
    public void casePage(Page page) {
        pages.add(page);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseStyleSheet(this);
    }

    @Override
    public void updateStates(HeadlessFormInterpreter headlessFormInterpreter, List<Default> defaultList) {
        for (Page p : pages) {
            p.updateStates(headlessFormInterpreter, defaultList);
        }
    }

    public StyleSheet() {
        pages = new LinkedList<Page>();
        defaultSettings = new LinkedList<Default>();
    }
}
