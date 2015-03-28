package org.fugazi.qls.gui;

import org.fugazi.ql.gui.UIFormManager;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import java.util.ArrayList;
import java.util.List;

public class QLSUIFormManager extends UIFormManager {
    
    private final UIForm qlsForm;
    private List<UIQuestion> questionsInForm;
    private List<UIPage> pagesInForm;
    private List<UISection> sectionsInForm;

    public QLSUIFormManager(String _formTitle) {
        super(new QLSUIForm(_formTitle));
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
            this.pagesInForm.add(_page);
        }
    }

    public void removePage(UIPage _page) {
        if (this.pagesInForm.contains(_page)) {
            _page.removeFromForm(this.qlsForm);
            this.pagesInForm.remove(_page);
        }
    }

    public void addSection(UISection _section) {
        if (!this.sectionsInForm.contains(_section)) {
            _section.addToForm(this.qlsForm);
            this.sectionsInForm.add(_section);
        }
    }

    public void removeSection(UISection _section) {
        if (this.sectionsInForm.contains(_section)) {
            _section.removeFromForm(this.qlsForm);
            this.sectionsInForm.remove(_section);
        }
    }
}