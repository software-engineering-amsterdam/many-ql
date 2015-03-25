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
import org.fugazi.ql.gui.ui_elements.UIFormManager;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIComputedQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestionBuilder;
import org.fugazi.ql.gui.widgets.WidgetsFactory;

import java.util.*;

public class GUIBuilder implements IMediator {
    // typedef
    private class QuestionsWithConditionsState extends LinkedHashMap<UIQuestion, List<IfStatement>> {}

    private final ValueStorage valueStorage;
    private final GUIEvaluator guiEvaluator;
    private final UIFormManager uiFormManager;
    private final UIQuestionBuilder uiQuestionBuilder;
    
    private QuestionsWithConditionsState questionsWithConditionState = new QuestionsWithConditionsState();
    private List<ComputedQuestion> computedQuestions = new ArrayList<>();

    public GUIBuilder(Form _form, WidgetsFactory _widgetFactory) {
        this.valueStorage = new ValueStorage();
        this.guiEvaluator = new GUIEvaluator(valueStorage);
        
        this.uiFormManager = new UIFormManager(_form.getName());
        this.uiQuestionBuilder = new UIQuestionBuilder(this, valueStorage, _widgetFactory);

        QLFormDataStorage formDataStorage = new QLFormDataStorage(_form);
        questionsWithConditionState = this.createQuestionsWithConditions(formDataStorage);
        this.computedQuestions = formDataStorage.getComputedQuestions();
    }

    @Override
    public void getChangeFromColleagues(Colleague _origin) {
        this.storeValue(_origin.getId(), _origin.getState());
        this.checkComputedQuestions(this.computedQuestions);
        this.renderUI();
    }

    public void renderUI() {
        this.setupForm(this.questionsWithConditionState);
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

    private QuestionsWithConditionsState createQuestionsWithConditions(QLFormDataStorage _formDataStorage) {
        QuestionsWithConditionsState questionsWithCondition = new QuestionsWithConditionsState();

        for (Question question : _formDataStorage.getAllQuestions()) {
            UIQuestion uiQuestion = createUiQuestion(question);
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
    private void updateComputedQuestion(ComputedQuestion _computedQuestion) {
        ExpressionValue result = this.guiEvaluator.evaluateComputedExpression(_computedQuestion);
        UIComputedQuestion uiComputedQuestion =
                (UIComputedQuestion) this.getUIQuestionById(_computedQuestion.getIdName(), this.questionsWithConditionState);
        uiComputedQuestion.setComputedValue(result);
    }
    
    private void addIfStatementsToQuestion(
            List<IfStatement> _ifStatementsList,
            Question _question,
            QuestionsWithConditionsState _questionsWithConditionsState)
    {
        for (IfStatement ifStatement : _ifStatementsList) {
            if (ifStatement.getBody().contains(_question)) {
                UIQuestion uiQuestion = this.getUIQuestionById(_question.getIdName(), _questionsWithConditionsState);
                _questionsWithConditionsState.get(uiQuestion).add(ifStatement);
            }
        }
    }

    private UIQuestion getUIQuestionById(
            String _id, QuestionsWithConditionsState _questionsWithConditionsState) 
    {
        for (UIQuestion uiQuestion : _questionsWithConditionsState.keySet()) {
            if (_id.equals(uiQuestion.getId())) {
                return uiQuestion;
            }
        }
        return null;
    }

    public boolean isQuestionStateTrue(
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
    
    private void storeValue(String _id, ExpressionValue _value) {
        this.valueStorage.saveValue(_id, _value);
    }

    protected UIQuestion createUiQuestion(Question _question) {
        return _question.accept(this.uiQuestionBuilder);
    }    
}