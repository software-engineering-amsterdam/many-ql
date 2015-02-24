package org.fugazi.gui;

import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.*;
import org.fugazi.evaluator.Evaluator;
import org.fugazi.gui.ui_elements.UIComputedQuestion;
import org.fugazi.gui.ui_elements.UIElement;
import org.fugazi.gui.ui_elements.UIForm;
import org.fugazi.gui.ui_elements.UIQuestion;
import org.fugazi.gui.visitor.UITypeVisitor;

public class GUIBuilder implements IStatementVisitor<UIElement> {

    private final Form astForm;
    private final UIForm uiForm;
    private final Evaluator evaluator;
    private final ElementsObserver observer;

    public GUIBuilder(Form _astForm, Evaluator _evaluator) {
        this.astForm = _astForm;
        this.evaluator = _evaluator;
        this.uiForm = new UIForm(this.astForm.getName());
        this.observer = new ElementsObserver();
    }
    
    public void renderGUI() {
        setUpUIElements();
        this.uiForm.setVisible(true);
    }

    private void setUpUIElements() {
        for (Statement statement : astForm.getBody()) {
            statement.accept(this);
        }
    }

    private void addQuestionToTheForm(UIQuestion _quest) {
        _quest.addObserver(this.observer);
        this.uiForm.addElement(_quest);
    }

    /**
     * Statement Visitor
     */
    public UIElement visitQuestion(Question _question) {

        UITypeVisitor typeVisitor = new UITypeVisitor(_question);
        UIQuestion uiQuestion = _question.getType().accept(typeVisitor);

        addQuestionToTheForm(uiQuestion);

        return uiQuestion;
    }

    public UIElement visitIfStatement(IfStatement _ifStatement) {
        return null;
    }

    public UIElement visitComputedQuestion(ComputedQuestion _assignQuest) {
        UIComputedQuestion uiComputedQuestion = new UIComputedQuestion(_assignQuest);
        addQuestionToTheForm(uiComputedQuestion);
        return uiComputedQuestion;
    }
}