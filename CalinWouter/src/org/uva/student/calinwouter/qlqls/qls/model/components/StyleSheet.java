package org.uva.student.calinwouter.qlqls.qls.model.components;

import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.TypeToWidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractComponent;
import org.uva.student.calinwouter.qlqls.qls.model.helper.DefaultWidgetSettingsHelper;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

import java.util.LinkedList;
import java.util.List;

public class StyleSheet extends AbstractComponent<StyleSheet> {
    private String ident;
    private List<Page> pages;
    private int arg;

    public String getStyleSheetName() {
        return ident;
    }

    public List<Page> getPages() {
        return pages;
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
    public TypeToWidgetSettingsModel getTypeToWidgetSettingsModel() {
        return typeToWidgetSettingsModel;
    }

    @Override
    public void casePage(Page page) {
        page.setParent(this);
        pages.add(page);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseStyleSheet(this);
    }

    public StyleSheet(QLSInterpreter qlsInterpreter) {
        super(qlsInterpreter);
        pages = new LinkedList<Page>();
        try {
            typeToWidgetSettingsModel = new TypeToWidgetSettingsModel(DefaultWidgetSettingsHelper.createDefaultTypeToWidgetSettingsModel(qlsInterpreter));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
