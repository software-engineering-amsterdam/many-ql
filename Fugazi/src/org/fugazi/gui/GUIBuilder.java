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
import java.util.HashMap;

public class GUIBuilder implements IMediator, IStatementVisitor<Void> {

    private final Form astForm;
    private final UIForm uiForm;
    private final Evaluator evaluator;
    private final ValueStorage storage;

    private ArrayList<IfStatement> ifStatements = new ArrayList<>(); // used for their re-evaluation
    private ArrayList<ComputedQuestion> computedQuestions = new ArrayList<>(); // used for their re-evaluation
    
    private HashMap<String, UIQuestion> formQuestions = new HashMap<>(); // used for dynamic add/remove from form.

    public GUIBuilder(Form _astForm, ValueStorage _storage) {
        this.astForm = _astForm;
        this.storage = _storage;
        this.evaluator = new Evaluator(storage);
        this.uiForm = new UIForm(astForm.getName());
    }
    
    public void renderGUI() {
        this.getFormBody(astForm);
        this.uiForm.showForm();
    }

    private void addQuestionToTheForm(UIQuestion _quest) {
        if (!formQuestions.containsKey(_quest.getId())) { // don't add duplicates.
            formQuestions.put(_quest.getId(), _quest);
            this.uiForm.addQuestion(_quest);
        }
    }

    /**
     * Evaluation
     */
    private void getFormBody(Form _form) {
        _form.getBody().forEach(statement -> statement.accept(this));
    }

    private void getIfStatementBody(IfStatement _ifStatement) {
        _ifStatement.getBody().forEach(statement -> statement.accept(this));
    }

    private boolean evaluateIfStatement(IfStatement _ifStatement) {
        Expression condition = _ifStatement.getCondition();
        BoolValue result = (BoolValue) this.evaluator.evaluateExpression(condition); //todo: no casting?
        return result.getValue();
    }

    private ExpressionValue evaluateComputedQuestion(ComputedQuestion _computedQuest) {
        Expression expression = _computedQuest.getComputedExpression();
        ExpressionValue result = evaluator.evaluateExpression(expression);
        return result;
    }
    
    /**
     * Mediator
     */
    public void getChangeFromColleagues(Colleague _origin) {
        // save the new value.
        this.storage.saveValue(_origin.getId(), _origin.getState());
        
        // re-visit the conditions.
        ifStatements.forEach(ifStatement -> ifStatement.accept(this));

        // re-visit the computed questions.
        computedQuestions.forEach(quest -> quest.accept(this));
    }

    /**
     * Statement Visitor
     */
    public Void visitQuestion(Question _question) {
        UITypeVisitor typeVisitor = new UITypeVisitor(this, _question);
        UIQuestion uiQuestion = _question.getType().accept(typeVisitor);

        this.addQuestionToTheForm(uiQuestion);

        this.storage.saveValue(uiQuestion.getId(), uiQuestion.getState());

        return null;
    }

    public Void visitIfStatement(IfStatement _ifStatement) {
        if (!ifStatements.contains(_ifStatement)) {
            ifStatements.add(_ifStatement);
        }

        boolean isConditionTrue = this.evaluateIfStatement(_ifStatement);
        if (isConditionTrue) {
            getIfStatementBody(_ifStatement);
        }
        
        return null;
    }

    public Void visitComputedQuestion(ComputedQuestion _computedQuest) {
        if (!computedQuestions.contains(_computedQuest)) {
            computedQuestions.add(_computedQuest);
        }
        ExpressionValue result =  this.evaluateComputedQuestion(_computedQuest);
        this.storage.saveValue(_computedQuest.getIdName(), result);

        UIComputedQuestion uiComputedQuestion = new UIComputedQuestion(this, _computedQuest, storage.getRealValue(_computedQuest.getIdName()).toString());
        this.addQuestionToTheForm(uiComputedQuestion);
        
        return null;
    }
}