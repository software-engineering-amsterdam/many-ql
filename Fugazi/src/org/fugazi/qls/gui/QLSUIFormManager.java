package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import java.util.ArrayList;
import java.util.List;

public class QLSUIFormManager {
    private final QLSUIForm qlsForm;
    private List<UIQuestion> questionsInForm;
    private List<Page> pagesInForm;
    private List<Section> sectionsInForm;

    public QLSUIFormManager(String _formTitle) {
        this.qlsForm = new QLSUIForm(_formTitle);

        this.questionsInForm = new ArrayList<>();
        this.pagesInForm = new ArrayList<>();
        this.sectionsInForm = new ArrayList<>();
    }

    public void render() {
        this.qlsForm.showForm();
    }

    public void addQuestion(UIQuestion _uiQuestion) {
        if (!this.questionsInForm.contains(_uiQuestion)) {
            this.questionsInForm.add(_uiQuestion);
            _uiQuestion.addToForm(this.qlsForm);
        }
    }

    public void removeQuestion(UIQuestion _uiQuestion) {
        if (this.questionsInForm.contains(_uiQuestion)) {
            this.questionsInForm.remove(_uiQuestion);
            _uiQuestion.removeFromForm(this.qlsForm);
        }
    }

    public void addPage(UIPage _page) {
        if (!this.pagesInForm.contains(_page)) {
            _page.addToForm(this.qlsForm);
        }
    }

    public void removePage(UIPage _page) {
        if (this.pagesInForm.contains(_page)) {
            _page.removeFromForm(this.qlsForm);
        }
    }

    public void addSection(UISection _section) {
        if (!this.sectionsInForm.contains(_section)) {
            _section.addToForm(this.qlsForm);
        }
    }

    public void removeSection(UISection _section) {
        if (this.sectionsInForm.contains(_section)) {
            _section.removeFromForm(this.qlsForm);
        }
    }
}
