package org.fugazi.qls.gui;

import org.fugazi.ql.gui.UIFormManager;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import java.util.ArrayList;
import java.util.List;

/**
 * This class wraps the UIFormManager of qls, questions are still maintained in UIFormManager,
 * but this class maintain Pages and Sections in which the questions will be kept.
 */
public class QLSUIFormManager {
    
    private final QLSUIForm qlsForm;
    private List<Page> pagesInForm;
    private List<Section> sectionsInForm;

    private final UIFormManager formManager;

    public QLSUIFormManager(String _formTitle, UIFormManager _formManager) {
        this.formManager = _formManager;
        
        this.qlsForm = new QLSUIForm(_formTitle);
        this.formManager.setForm(this.qlsForm);     // TODO: this looks pretty ugly I think.

        this.pagesInForm = new ArrayList<>();
        this.sectionsInForm = new ArrayList<>();
    }

    public void render() {
        this.qlsForm.showForm();
    }

    public void addQuestion(UIQuestion _uiQuestion) {
        if (!this.formManager.getQuestionsInForm().contains(_uiQuestion)) {
            this.formManager.getQuestionsInForm().add(_uiQuestion);
            _uiQuestion.addToForm(this.qlsForm);
        }
    }

    public void removeQuestion(UIQuestion _uiQuestion) {
        if (this.formManager.getQuestionsInForm().contains(_uiQuestion)) {
            this.formManager.getQuestionsInForm().remove(_uiQuestion);
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
