package org.fugazi.gui;

import org.fugazi.ValueStorage;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.*;
import org.fugazi.evaluator.Evaluator;
import org.fugazi.evaluator.expression_value.BoolValue;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.ui_elements.UIComputedQuestion;
import org.fugazi.gui.ui_elements.UIForm;
import org.fugazi.gui.ui_elements.UIQuestion;
import org.fugazi.gui.visitor.UITypeVisitor;

public class GUIBuilder implements IStatementVisitor<UIQuestion> {

    private final Form astForm;
    private final UIForm uiForm;
    private final Evaluator evaluator;
    private final UIMediator mediator;
    private final ValueStorage storage;

    public GUIBuilder(Form _astForm, ValueStorage _storage) {
        this.astForm = _astForm;
        this.storage = _storage;
        this.evaluator = new Evaluator(storage);
        this.uiForm = new UIForm(astForm.getName());
        this.mediator = new UIMediator(storage);
    }
    
    public void renderGUI() {
        setUpUIElements();
        this.uiForm.showForm();
    }

    private void setUpUIElements() {
        astForm.getBody()
                .forEach(statement -> statement.accept(this));
    }

    private void addQuestionToTheForm(UIQuestion _quest) {
        this.uiForm.addQuestion(_quest);
    }
    
    private void reRender() {
        // todo
    }

    /**
     * Statement Visitor
     */
    public UIQuestion visitQuestion(Question _question) {

        UITypeVisitor typeVisitor = new UITypeVisitor(mediator, _question);
        UIQuestion uiQuestion = _question.getType().accept(typeVisitor);

        addQuestionToTheForm(uiQuestion);

        return uiQuestion;
    }

    public UIQuestion visitIfStatement(IfStatement _ifStatement) {
        
        System.out.println("Condition: " + _ifStatement.getCondition().toString());
        
        Expression condition = _ifStatement.getCondition();
        
        // todo: no casting?
        BoolValue result = (BoolValue) this.evaluator.evaluateExpression(condition);
        System.out.println("Condition - Result: " + result.getValue());
        
        if (result.getValue()) {
            _ifStatement.getBody()
                    .forEach(statement -> statement.accept(this));
        }
        
        this.reRender();
        
        return null;
    }

    public UIQuestion visitComputedQuestion(ComputedQuestion _computedQuest) {
        
        UIComputedQuestion uiComputedQuestion = new UIComputedQuestion(mediator, _computedQuest);

        Expression expression = _computedQuest.getComputedExpression();
        ExpressionValue result = evaluator.evaluateExpression(expression);

        System.out.println("Computed Expression : " + expression.toString());
        System.out.println("Computed Expression - Result: " + result.getValue());
        // todo: set the result.
        
        addQuestionToTheForm(uiComputedQuestion); // reRender
        
        return uiComputedQuestion;
    }
}