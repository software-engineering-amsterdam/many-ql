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

    public GUIBuilder(Form _astForm) {
        this.astForm = _astForm;
        this.storage = new ValueStorage();
        this.evaluator = new Evaluator(storage);
        this.uiForm = new UIForm(astForm.getName());
    }
    
    public void renderGUI() {
        this.setupUiElements(astForm);
        this.uiForm.showForm();
    }

    private void setupUiElements(Form _form) {
        _form.getBody().forEach(statement -> statement.accept(this));
    }
    
    private void setupIfStatementBody(IfStatement _ifStatement) {
        _ifStatement.getBody().forEach(statement -> statement.accept(this));
    }

    private void removeIfStatementBody(IfStatement _ifStatement) {
        //_ifStatement.getBody().forEach(statement -> statement.accept(this));
    }

    /**
     * Body Management
     */
    private void addQuestionToTheForm(UIQuestion _quest) {
        if (!formQuestions.containsKey(_quest.getId())) { // don't add duplicates.
            this.storage.saveValue(_quest.getId(), _quest.getState());
            formQuestions.put(_quest.getId(), _quest);
            this.uiForm.addQuestion(_quest);
        }
    }

    private void removeQuestionToTheForm(UIQuestion _quest) {
        if (formQuestions.containsKey(_quest.getId())) {
            UIQuestion question = formQuestions.get(_quest.getId());
            this.uiForm.removeQuestion(question);
        }
    }

    private void addIfStatement(IfStatement _ifStatement) {
        if (!ifStatements.contains(_ifStatement)) {
            ifStatements.add(_ifStatement);
        }
    }

    private void addComputedQuestion(ComputedQuestion _computedQuest) {
        if (!computedQuestions.contains(_computedQuest)) {
            computedQuestions.add(_computedQuest);
        }
    }

    /**
     * Mediator messages
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
     * Evaluation
     */
    private boolean evaluateIfStatement(IfStatement _ifStatement) {
        BoolValue result = (BoolValue) this.evaluator.evaluateExpression(_ifStatement.getCondition());
        return result.getValue();
    }

    private ExpressionValue evaluateComputedQuestion(ComputedQuestion _computedQuest) {
        Expression expression = _computedQuest.getComputedExpression();
        return evaluator.evaluateExpression(expression);
    }

    /**
     * Statement Visitor
     */
    public Void visitQuestion(Question _question) {
        UITypeVisitor typeVisitor = new UITypeVisitor(this, _question);
        UIQuestion uiQuestion = _question.getType().accept(typeVisitor);
        this.addQuestionToTheForm(uiQuestion);
        return null;
    }

    public Void visitIfStatement(IfStatement _ifStatement) {
        this.addIfStatement(_ifStatement);

        boolean isConditionTrue = this.evaluateIfStatement(_ifStatement);
        if (isConditionTrue) {
            this.setupIfStatementBody(_ifStatement);
        } else {
            this.removeIfStatementBody(_ifStatement);
        }
        
        return null;
    }

    public Void visitComputedQuestion(ComputedQuestion _computedQuest) {
        this.addComputedQuestion(_computedQuest);
        
        ExpressionValue result = this.evaluateComputedQuestion(_computedQuest);
        this.storage.saveValue(_computedQuest.getIdName(), result);
        
        if (!formQuestions.containsKey(_computedQuest.getIdName())) {
            UIComputedQuestion uiComputedQuestion = new UIComputedQuestion(this, _computedQuest, result);
            this.addQuestionToTheForm(uiComputedQuestion);
        } else {
            UIComputedQuestion uiComputedQuestion = (UIComputedQuestion) formQuestions.get(_computedQuest.getIdName());
            uiComputedQuestion.setComputedValue(result);
        }
        
        return null;
    }
}