package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractComponent;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

import java.util.LinkedList;
import java.util.List;

public class Page extends AbstractComponent<Page> {
    private String ident;
    private List<Section> sections;
    private int arg;

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

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public void caseSection(Section section) {
        section.setParent(this);
        sections.add(section);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.casePage(this);
    }

    public Page(QLSInterpreter qlsInterpreter) {
        super(qlsInterpreter);
        sections = new LinkedList<Section>();
    }
}
