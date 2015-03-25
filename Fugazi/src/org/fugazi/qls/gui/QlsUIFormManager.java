package org.fugazi.qls.gui;

import org.fugazi.ql.gui.UIFormManager;
import org.fugazi.qls.gui.ui_segment.JPage;
import org.fugazi.qls.gui.ui_segment.JSection;

public class QlsUIFormManager extends UIFormManager {
    private final QlsUIForm qlsForm;

    public QlsUIFormManager(String _formTitle, QlsUIPanel _panel) {
        super(_formTitle, _panel);
        this.qlsForm = new QlsUIForm(_formTitle, _panel);
    }

    @Override
    public void render() {
        this.qlsForm.showForm();
    }

    public void addPage(JPage _page) {
        // todo check if page contains form
        _page.addToForm(this.qlsForm);
    }

    public void removePage(JPage _page) {
        // todo check if page contains form
        _page.removeFromForm(this.qlsForm);
    }

    public void addSection(JSection _section) {
        _section.addToForm(this.qlsForm);
    }
}
