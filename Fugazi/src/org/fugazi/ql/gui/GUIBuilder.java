package org.fugazi.ql.gui;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.mediator.Colleague;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIComputedQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestionBuilder;
import org.fugazi.ql.gui.widgets.WidgetsFactory;

import java.util.*;

public class GUIBuilder implements IMediator {
    private class QuestionsWithConditions extends LinkedHashMap<UIQuestion, List<IfStatement>> {}

    private final ValueStorage valueStorage;
    private final GUIEvaluator guiEvaluator;
    private final UIQuestionBuilder uiQuestionBuilder;
    
    protected final UIFormManager uiFormManager;
    protected QuestionsWithConditions questionsWithConditions = new QuestionsWithConditions();
    private List<ComputedQuestion> computedQuestions = new ArrayList<>();

    public GUIBuilder(Form _form, WidgetsFactory _widgetFactory) {
        this.valueStorage = new ValueStorage();
        this.guiEvaluator = new GUIEvaluator(valueStorage);

        this.uiFormManager = new UIFormManager(_form.getName());
        this.uiQuestionBuilder = new UIQuestionBuilder(this, valueStorage, _widgetFactory);

        QLFormDataStorage formDataStorage = new QLFormDataStorage(_form);
        this.questionsWithConditions = this.createQuestionsWithConditions(formDataStorage);
        this.computedQuestions = formDataStorage.getComputedQuestions();
    }

    @Override
    public void getChangeFromColleagues(Colleague _origin) {
        this.storeValue(_origin.getId(), _origin.getState());
        this.checkComputedQuestions(this.computedQuestions);
        this.renderUI();
    }

    public void renderUI() {
        this.setupForm(this.questionsWithConditions);
        this.uiFormManager.render();
    }

    private void setupForm(Map<UIQuestion, List<IfStatement>> _questionsWithConditionState) {
        for (UIQuestion uiQuestion : _questionsWithConditionState.keySet()) {
            if (this.isQuestionStateTrue(_questionsWithConditionState, uiQuestion)) {
                this.uiFormManager.addQuestion(uiQuestion);
            } else {
                this.uiFormManager.removeQuestion(uiQuestion);
            }
        }
    }

    private void checkComputedQuestions(List<ComputedQuestion> _computedQuestions) {
        for (ComputedQuestion computedQuestion : _computedQuestions) {
            this.updateComputedQuestion(computedQuestion);
        }
    }

    private QuestionsWithConditions createQuestionsWithConditions(QLFormDataStorage _formDataStorage) {
        QuestionsWithConditions questionsWithCondition = new QuestionsWithConditions();

        for (Question question : _formDataStorage.getAllQuestions()) {
            
            UIQuestion uiQuestion = this.createUiQuestion(question);
            
            this.storeValue(uiQuestion.getId(), uiQuestion.getState());
            
            questionsWithCondition.put(uiQuestion, new ArrayList<>());
            
            this.addIfStatementsToQuestion(
                    _formDataStorage.getIfStatements(), question, questionsWithCondition);
        }
        return questionsWithCondition;
    }

    /**
     * Helper Functions.
     */
    private void addIfStatementsToQuestion(
            List<IfStatement> _ifStatementsList,
            Question _question,
            QuestionsWithConditions _questionsWithConditions)
    {
        for (IfStatement ifStatement : _ifStatementsList) {
            if (ifStatement.getBody().contains(_question)) {
                UIQuestion uiQuestion = this.getUIQuestionById(_question.getIdName(), _questionsWithConditions);
                _questionsWithConditions.get(uiQuestion).add(ifStatement);
            }
        }
    }
    
    protected void updateComputedQuestion(ComputedQuestion _computedQuestion) {
        ExpressionValue result = this.guiEvaluator.evaluateComputedExpression(_computedQuestion);
        UIComputedQuestion uiComputedQuestion =
                (UIComputedQuestion) this.getUIQuestionById(_computedQuestion.getIdName(), this.questionsWithConditions);
        uiComputedQuestion.setComputedValue(result);
    }

    protected UIQuestion getUIQuestionById(
            String _id, QuestionsWithConditions _questionsWithConditions)
    {
        for (UIQuestion uiQuestion : _questionsWithConditions.keySet()) {
            if (_id.equals(uiQuestion.getId())) {
                return uiQuestion;
            }
        }
        return null;
    }

    protected boolean isQuestionStateTrue(
            Map<UIQuestion, List<IfStatement>> _questionsWithConditionState, UIQuestion _question)
    {
        boolean isTrue = true;
        for (IfStatement ifStatement : _questionsWithConditionState.get(_question)) {
            if (!this.guiEvaluator.evaluateIfStatement(ifStatement)) {
                isTrue = false;
            }
        }
        return isTrue;
    }

    protected void storeValue(String _id, ExpressionValue _value) {
        this.valueStorage.saveValue(_id, _value);
    }

    protected UIQuestion createUiQuestion(Question _question) {
        return _question.accept(this.uiQuestionBuilder);
    }    
}