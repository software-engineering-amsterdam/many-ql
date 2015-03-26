package org.fugazi.qls.gui;

import org.fugazi.ql.gui.UIFormManager;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

public class QLSUIFormManager extends UIFormManager {
    private final QLSUIForm qlsForm;

    // TODO REMOVES

    public QLSUIFormManager(String _formTitle, QLSUIPanel _panel) {
        super(_formTitle, _panel);
        this.qlsForm = new QLSUIForm(_formTitle, _panel);
    }

    @Override
    public void render() {
        this.qlsForm.showForm();
    }

    @Override
    public void addQuestion(UIQuestion _uiQuestion) {
        _uiQuestion.addToForm(this.qlsForm);
    }

    public void addPage(UIPage _page) {
        // todo check if page contains form
        _page.addToForm(this.qlsForm);
    }

    public void removePage(UIPage _page) {
        // todo check if page contains form
        _page.removeFromForm(this.qlsForm);
    }

    public void addSection(UISection _section) {

        _section.addToForm(this.qlsForm);
    }
}
