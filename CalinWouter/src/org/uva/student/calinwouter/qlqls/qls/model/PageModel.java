package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.qls.components.Section;

import java.util.List;

public class PageModel<T> {
    private String pageName;
    private List<SectionModel> sections;
    private List<DefaultModel> defaults;

    public PageModel(String pageName, List<SectionModel> sections, List<DefaultModel> defaults) {
        this.pageName = pageName;
        this.sections = sections;
        this.defaults = defaults;
    }

}
