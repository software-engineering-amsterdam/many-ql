package org.fugazi.gui;

import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.Statement;
import org.fugazi.evaluator.Evaluator;
import org.fugazi.gui.ui_elements.UIForm;
import org.fugazi.gui.ui_elements.UIQuestion;
import org.fugazi.gui.visitors.UIStatementVisitor;

public class GUIManager {

    private final Form astForm;
    private final UIForm uiForm;
    private final Evaluator evaluator;
    private final UIStatementVisitor statementVisitor;

    public GUIManager(Form _astForm, Evaluator _evaluator) {
        this.astForm = _astForm;
        this.evaluator = _evaluator;
        this.statementVisitor = new UIStatementVisitor();
        this.uiForm = new UIForm(this.astForm.getName());
    }
    
    public void renderGUI() {
        setUpLayout();
        this.uiForm.setVisible(true);
    }

    private void setUpLayout() {
        for (Statement statement : astForm.getBody()) {
            UIQuestion uiQuestion = statement.accept(this.statementVisitor);
            uiForm.addQuestion(uiQuestion);
        }
    }
}