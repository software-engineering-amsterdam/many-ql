package org.fugazi.qls.gui;

import org.fugazi.ql.gui.UIFormManager;
import org.fugazi.qls.gui.ui_element.QLSUIForm;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import java.util.ArrayList;
import java.util.List;

public class QLSUIFormManager extends UIFormManager {

    private List<UIPage> pagesInForm;
    private List<UISection> sectionsInForm;

    public QLSUIFormManager(String _formTitle) {
        super(new QLSUIForm(_formTitle));

        this.pagesInForm = new ArrayList<>();
        this.sectionsInForm = new ArrayList<>();
    }

    public void addPage(UIPage _page) {
        if (!this.pagesInForm.contains(_page)) {
            _page.addToForm(this.form);
            this.pagesInForm.add(_page);
        }
    }

    public void removePage(UIPage _page) {
        if (this.pagesInForm.contains(_page)) {
            _page.removeFromForm(this.form);
            this.pagesInForm.remove(_page);
        }
    }

    public void addSection(UISection _section) {
        if (!this.sectionsInForm.contains(_section)) {
            _section.addToForm(this.form);
            this.sectionsInForm.add(_section);
        }
    }

    public void removeSection(UISection _section) {
        if (this.sectionsInForm.contains(_section)) {
            _section.removeFromForm(this.form);
            this.sectionsInForm.remove(_section);
        }
    }
}