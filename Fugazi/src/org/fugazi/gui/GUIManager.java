package org.fugazi.gui;

import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.Question;
import org.fugazi.ast.statement.Statement;
import org.fugazi.evaluator.Evaluator;
import org.fugazi.gui.ui_elements.UIForm;
import org.fugazi.gui.ui_elements.UIQuestion;
import org.fugazi.gui.ui_elements.UIQuestionFactory;

public class GUIManager {
    
    public static final int winHeight = 600;
    public static final int winWidth = 480;

    private final Form astForm;
    private final UIForm uiForm;
    private final Evaluator evaluator;

    public GUIManager(Form _astForm, Evaluator _evaluator) {
        this.astForm = _astForm;
        this.evaluator = _evaluator;
        this.uiForm = new UIForm(this.astForm.getName());
    }
    
    public void renderGUI() {
        setUpLayout();
        setWindowPreferences();
        this.uiForm.setVisible(true);
    }
    
    private void setWindowPreferences() {
        this.uiForm.setSize(winWidth, winHeight);
        this.uiForm.setLocationRelativeTo(null);
    }
    
    private void setUpLayout() {
        UIQuestionFactory questionFactory = new UIQuestionFactory();
        for (Statement statement : astForm.getBody()) {
            if (statement instanceof Question) {
                UIQuestion question = questionFactory.getUIQuestion((Question)statement);
                this.uiForm.addQuestion(question.getComponent());
            }
        }
    }
}