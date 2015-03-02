package org.uva.student.calinwouter.qlqls.model;

import java.util.HashMap;
import java.util.List;

public class StyleSheetModel {

    private boolean styled;

    private List<PageModel> pages;

    private List<IFieldModel> fields;

    private List<DefaultModel> defaultSettings;

    public void setDefaultWidget(String type, WidgetSettingsModel parameters) {}

    // QL
    public void addField(IFieldModel field) {}

    // QLS
    public void addPage(PageModel page) {}

    public void setQuestionSection(String ident, SectionModel section) {}


}
