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

    private final ValueStorage valueStorage;
    private final GUIEvaluator guiEvaluator;
    private final UIForm uiForm;

    private Map<UIQuestion, List<IfStatement>> questionsWithConditionState = new LinkedHashMap<>();
    private List<UIQuestion> questionsInForm = new ArrayList<>();
    private List<ComputedQuestion> computedQuestions = new ArrayList<>();
    
    private UIQuestionBuilder uiQuestionBuilder;

    public GUIBuilder(Form _form, WidgetsFactory _widgetFactory) {
        this.valueStorage = new ValueStorage();
        this.guiEvaluator = new GUIEvaluator(valueStorage);
        this.uiForm = new UIForm(_form.getName(), new JPanel());
        this.uiQuestionBuilder = new UIQuestionBuilder(this, valueStorage, _widgetFactory);

        this.addConditionsToQuestions(_form);
        this.addComputedQuestions(_form);
    }

    public void renderUI() {
        this.setupForm(this.questionsWithConditionState);
        this.uiForm.showForm();
    }

    @Override
    public void getChangeFromColleagues(Colleague _origin) {
        this.valueStorage.saveValue(_origin.getId(), _origin.getState());
        this.checkComputedQuestions(this.computedQuestions);
        this.renderUI();
    }

    private void setupForm(
            Map<UIQuestion, List<IfStatement>> _questionsWithConditionState) {
        for (UIQuestion uiQuestion : _questionsWithConditionState.keySet()) {
            if (this.guiEvaluator.isQuestionStateTrue(_questionsWithConditionState, uiQuestion)) {
                this.addQuestionToForm(uiQuestion);
            } else {
                this.removeQuestionFromForm(uiQuestion);
            }
        }
    }

    private void addQuestionToForm(UIQuestion _uiQuestion) {
        if (!this.questionsInForm.contains(_uiQuestion)) {
            this.questionsInForm.add(_uiQuestion);
            _uiQuestion.addToForm(this.uiForm);
        }
    }

    private void removeQuestionFromForm(UIQuestion _uiQuestion) {
        if (this.questionsInForm.contains(_uiQuestion)) {
            this.questionsInForm.remove(_uiQuestion);
            _uiQuestion.removeFromForm(this.uiForm);
        }
    }

    private void addComputedQuestions(Form _form) {
        QLFormDataStorage formDataStorage = new QLFormDataStorage(_form);
        this.computedQuestions = formDataStorage.getComputedQuestions();
    }

    private void checkComputedQuestions(List<ComputedQuestion> _computedQuestions) {
        for (ComputedQuestion computedQuestion : _computedQuestions) {
            UIQuestion uiQuestion = this.getUIQuestionById(computedQuestion.getIdName());
            this.changeSingleComputedQuestion(computedQuestion, uiQuestion);
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
    
    private void changeSingleComputedQuestion(ComputedQuestion _computedQuestion, UIQuestion _uiQuestion) {
        ExpressionValue result = this.guiEvaluator.evaluateComputedExpression(_computedQuestion);
        UIComputedQuestion uiComputedQuestion = (UIComputedQuestion) _uiQuestion;
        uiComputedQuestion.setComputedValue(result);
    }

    private void addConditionsToQuestions(Form _form) {
        QLFormDataStorage formDataStorage = new QLFormDataStorage(_form);
        List<Question> questionsList = formDataStorage.getAllQuestions();
        List<IfStatement> ifStatementsList = formDataStorage.getIfStatements();

        // Get all the questions of the form.
        for (Question question : questionsList) {
            UIQuestion uiQuestion = createUiQuestion(question);
            this.valueStorage.saveValue(uiQuestion.getId(), uiQuestion.getState()); // save defaults
            this.questionsWithConditionState.put(uiQuestion, new ArrayList<>());

            // get if statements which the questionsInForm are included.
            for (IfStatement ifStatement : ifStatementsList) {
                if (ifStatement.getBody().contains(question)) {
                    this.questionsWithConditionState.get(uiQuestion).add(ifStatement);
                }
            }
        }
    }

    protected UIQuestion createUiQuestion(Question _question) {
        return _question.accept(this.uiQuestionBuilder);
    }    
}