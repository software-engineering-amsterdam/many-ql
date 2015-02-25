package org.fugazi.gui;

import org.fugazi.ValueStorage;
import org.fugazi.ast.form.Form;
import org.fugazi.evaluator.Evaluator;
import org.fugazi.gui.ui_elements.UIForm;
import org.fugazi.gui.ui_elements.UIQuestion;
import org.fugazi.gui.visitor.UIStatementVisitor;

public class GUIBuilder {

    private final Form astForm;
    private final UIForm uiForm;
    private final Evaluator evaluator;
    private final UIMediator mediator;
    private final ValueStorage storage;
    private final UIStatementVisitor statementVisitor;

    public GUIBuilder(Form _astForm, ValueStorage _storage) {
        this.astForm = _astForm;
        this.storage = _storage;
        this.evaluator = new Evaluator(storage);
        this.uiForm = new UIForm(astForm.getName());
        this.mediator = new UIMediator(storage);
        this.statementVisitor = new UIStatementVisitor(evaluator, mediator);
    }
    
    public void renderGUI() {
        addUIElements();
        this.uiForm.showForm();
    }
    
    private void getUIElements() {

    }

    private void addUIElements() {
        astForm.getBody()
                .forEach(statement -> statement.accept(this.statementVisitor));
    }

    private void addQuestionToTheForm(UIQuestion _quest) {
        this.uiForm.addQuestion(_quest);
    }
}