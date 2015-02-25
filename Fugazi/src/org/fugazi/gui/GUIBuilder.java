package org.fugazi.gui;

import org.fugazi.ValueStorage;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.*;
import org.fugazi.evaluator.Evaluator;
import org.fugazi.evaluator.expression_value.BoolValue;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.mediator.Colleague;
import org.fugazi.gui.mediator.IMediator;
import org.fugazi.gui.ui_elements.*;
import org.fugazi.gui.visitor.UITypeVisitor;

import java.util.ArrayList;

public class GUIBuilder implements IMediator, IStatementVisitor<UIQuestion> {

    private final Form astForm;
    private final UIForm uiForm;
    private final Evaluator evaluator;
    private final ValueStorage storage;

    private ArrayList<IfStatement> ifStatements = new ArrayList<>();

    public GUIBuilder(Form _astForm, ValueStorage _storage) {
        this.astForm = _astForm;
        this.storage = _storage;
        this.evaluator = new Evaluator(storage);
        this.uiForm = new UIForm(astForm.getName());
    }
    
    public void renderGUI() {
        this.setUpUIElements();
        this.uiForm.showForm();
    }

    private void setUpUIElements() {
        astForm.getBody()
                .forEach(statement -> statement.accept(this));
    }

    private void addQuestionToTheForm(UIQuestion _quest) {
        this.uiForm.addQuestion(_quest);
    }

    /**
     * Mediator
     */
    public void notify(Colleague _origin) {
        this.storage.saveValue(_origin.getId(), _origin.getState());
        ifStatements.forEach(ifStatement -> evaluateIfStatement(ifStatement));
    }

    /**
     * Statement Visitor
     */
    private void evaluateIfStatement(IfStatement _ifStatement) {
        Expression condition = _ifStatement.getCondition();

        // todo: no casting?
        BoolValue result = (BoolValue) this.evaluator.evaluateExpression(condition);
        if (result.getValue()) {
            _ifStatement.getBody()
                    .forEach(statement -> statement.accept(this));
        }
    }

    private void evaluateComputedQuestion(ComputedQuestion _computedQuest) {
        Expression expression = _computedQuest.getComputedExpression();
        ExpressionValue result = evaluator.evaluateExpression(expression);
        this.storage.saveValue(_computedQuest.getIdName(), result);
    }

    public UIQuestion visitQuestion(Question _question) {
        UITypeVisitor typeVisitor = new UITypeVisitor(this, _question);
        UIQuestion uiQuestion = _question.getType().accept(typeVisitor);
        this.addQuestionToTheForm(uiQuestion);

        this.storage.saveValue(uiQuestion.getId(), uiQuestion.getState());

        return uiQuestion;
    }

    public UIQuestion visitIfStatement(IfStatement _ifStatement) {
        ifStatements.add(_ifStatement);
        this.evaluateIfStatement(_ifStatement);
        return null;
    }

    public UIQuestion visitComputedQuestion(ComputedQuestion _computedQuest) {
        this.evaluateComputedQuestion(_computedQuest);
        UIComputedQuestion uiComputedQuestion =
                new UIComputedQuestion(this,
                        _computedQuest,
                        storage.getRealValue(_computedQuest.getIdName()).toString()
                );
        this.addQuestionToTheForm(uiComputedQuestion);

        return uiComputedQuestion;
    }
}