package org.fugazi.qls.gui;

import org.fugazi.ql.gui.UIFormManager;
import org.fugazi.ql.gui.ui_elements.IUIForm;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import java.util.ArrayList;
import java.util.List;

public class QLSUIFormManager {
    private final QLSUIForm qlsForm;
    private List<UIQuestion> questionsInForm;


    // TODO REMOVES

    public QLSUIFormManager(String _formTitle, QLSUIPanel _panel) {
        this.qlsForm = new QLSUIForm(_formTitle, _panel);
        this.questionsInForm = new ArrayList<>();
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
