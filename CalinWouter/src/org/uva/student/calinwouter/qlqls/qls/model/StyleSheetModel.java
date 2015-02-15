package org.uva.student.calinwouter.qlqls.qls.model;

import java.util.List;

public class StyleSheetModel {

    private List<PageModel> pages;

    public StyleSheetModel(List<PageModel> pages, List<DefaultModel> defaults) {
        this.pages = pages;
    }

}
