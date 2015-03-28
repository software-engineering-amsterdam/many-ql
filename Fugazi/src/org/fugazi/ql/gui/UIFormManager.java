package org.fugazi.ql.gui;

import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;

import java.util.ArrayList;
import java.util.List;

public class UIFormManager {
    private UIForm form;
    private List<UIQuestion> questionsInForm;

    public UIFormManager(UIForm _form) {
        this.form = _form;
        this.questionsInForm = new ArrayList<>();
    }
    
    public void render() {
        this.form.showForm();
    }

    public void addQuestion(UIQuestion _uiQuestion) {
        if (!this.questionsInForm.contains(_uiQuestion)) {
            this.questionsInForm.add(_uiQuestion);
            _uiQuestion.addToForm(this.form);
        }
    }

    public void removeQuestion(UIQuestion _uiQuestion) {
        if (this.questionsInForm.contains(_uiQuestion)) {
            this.questionsInForm.remove(_uiQuestion);
            _uiQuestion.removeFromForm(this.form);
        }
    }
}
