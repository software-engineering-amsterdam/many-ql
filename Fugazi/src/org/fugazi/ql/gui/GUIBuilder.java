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
import org.fugazi.ql.gui.ui_elements.UIComputedQuestion;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.ui_elements.UIQuestion;
import org.fugazi.ql.gui.ui_elements.UIQuestionBuilder;
import org.fugazi.ql.gui.widgets.WidgetsFactory;

import javax.swing.*;
import java.util.*;

public class GUIBuilder implements IMediator {

    // typedef
    private class QuestionsWithConditionsState extends LinkedHashMap<UIQuestion, List<IfStatement>> {}

    private final ValueStorage valueStorage;
    private final GUIEvaluator guiEvaluator;
    private final UIForm uiForm;

    private QuestionsWithConditionsState questionsWithConditionState;
    private List<ComputedQuestion> computedQuestions;
    
    private UIQuestionBuilder uiQuestionBuilder;
    private final FormQuestionsHandler formQuestionsHandler;

    public GUIBuilder(Form _form, WidgetsFactory _widgetFactory) {
        this.valueStorage = new ValueStorage();
        this.guiEvaluator = new GUIEvaluator(valueStorage);
        this.uiForm = new UIForm(_form.getName(), new JPanel());
        this.uiQuestionBuilder = new UIQuestionBuilder(this, valueStorage, _widgetFactory);

        this.formQuestionsHandler = new FormQuestionsHandler(this.uiForm);
        
        this.questionsWithConditionState = new QuestionsWithConditionsState();
        this.computedQuestions = new ArrayList<>();

        QLFormDataStorage formDataStorage = new QLFormDataStorage(_form);
        this.createQuestionsWithConditions(formDataStorage);
        this.addComputedQuestions(formDataStorage);
    }

    public void renderUI() {
        this.setupForm(this.questionsWithConditionState);
        this.uiForm.showForm();
    }

    @Override
    public void getChangeFromColleagues(Colleague _origin) {
        this.storeValue(_origin.getId(), _origin.getState());
        this.checkComputedQuestions(this.computedQuestions);
        this.renderUI();
    }

    private void setupForm(Map<UIQuestion, List<IfStatement>> _questionsWithConditionState) {
        for (UIQuestion uiQuestion : _questionsWithConditionState.keySet()) {
            if (this.guiEvaluator.isQuestionStateTrue(_questionsWithConditionState, uiQuestion)) {
                this.formQuestionsHandler.addQuestion(uiQuestion);
            } else {
                this.formQuestionsHandler.removeQuestion(uiQuestion);
            }
        }
    }

    private void addComputedQuestions(QLFormDataStorage _formDataStorage) {
        this.computedQuestions = _formDataStorage.getComputedQuestions();
    }

    private void checkComputedQuestions(List<ComputedQuestion> _computedQuestions) {
        for (ComputedQuestion computedQuestion : _computedQuestions) {
            this.updateComputedQuestion(computedQuestion);
        }
    }
    
    private void updateComputedQuestion(ComputedQuestion _computedQuestion) {
        ExpressionValue result = this.guiEvaluator.evaluateComputedExpression(_computedQuestion);
        UIComputedQuestion uiComputedQuestion = (UIComputedQuestion) this.getUIQuestionById(_computedQuestion.getIdName());
        uiComputedQuestion.setComputedValue(result);
    }

    private void createQuestionsWithConditions(QLFormDataStorage _formDataStorage) {
        this.questionsWithConditionState = new QuestionsWithConditionsState();

        for (Question question : _formDataStorage.getAllQuestions()) {
            UIQuestion uiQuestion = createUiQuestion(question);
            this.storeValue(uiQuestion.getId(), uiQuestion.getState());
            this.questionsWithConditionState.put(uiQuestion, new ArrayList<>());
            this.addIfStatementsToQuestion(
                    _formDataStorage.getIfStatements(), question, this.questionsWithConditionState);
        }
    }
    
    private void addIfStatementsToQuestion(
            List<IfStatement> _ifStatementsList,
            Question _question,
            QuestionsWithConditionsState _questionsWithConditionsState)
    {
        // get if statements which the questionsInForm are included.
        for (IfStatement ifStatement : _ifStatementsList) {
            if (ifStatement.getBody().contains(_question)) {
                UIQuestion uiQuestion = this.getUIQuestionById(_question.getIdName());
                _questionsWithConditionsState.get(uiQuestion).add(ifStatement);
            }
        }
    }

    private UIQuestion getUIQuestionById(String _id) {
        for (UIQuestion uiQuestion : this.questionsWithConditionState.keySet()) {
            if (_id.equals(uiQuestion.getId())) {
                return uiQuestion;
            }
        }
        return null;
    }
    
    private void storeValue(String _id, ExpressionValue _value) {
        this.valueStorage.saveValue(_id, _value);
    }

    protected UIQuestion createUiQuestion(Question _question) {
        return _question.accept(this.uiQuestionBuilder);
    }    
}