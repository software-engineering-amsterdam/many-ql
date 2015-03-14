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
import org.fugazi.ql.gui.visitor.UIQuestionBuilder;

import java.util.*;

public class GUIBuilder implements IMediator {

    private final ValueStorage valueStorage;
    private final GUIEvaluator guiEvaluator;
    private final UIForm uiForm;

    private Map<UIQuestion, List<IfStatement>> questionsWithState = new LinkedHashMap<>();
    private List<UIQuestion> questionsInForm = new ArrayList<>();
    private List<ComputedQuestion> computedQuestions = new ArrayList<>();

    public GUIBuilder(Form _form) {
        this.valueStorage = new ValueStorage();
        this.guiEvaluator = new GUIEvaluator(valueStorage);
        this.uiForm = new UIForm(_form.getName());

        this.addIfStatementsToQuestion(_form);
        this.addComputedQuestions(_form);
    }

    public void renderUI() {
        setupForm();
        uiForm.showForm();
    }

    @Override
    public void getChangeFromColleagues(Colleague _origin) {
        valueStorage.saveValue(_origin.getId(), _origin.getState());
        checkComputedQuestions();
        renderUI();
    }

    private void setupForm() {
        for (UIQuestion uiQuestion : questionsWithState.keySet()) {
            if (isQuestionStateTrue(uiQuestion)) {
                addQuestionToForm(uiQuestion);
            } else {
                removeQuestionFromForm(uiQuestion);
            }
        }
    }

    private void addQuestionToForm(UIQuestion _uiQuestion) {
        if (!questionsInForm.contains(_uiQuestion)) {
            questionsInForm.add(_uiQuestion);
            uiForm.addQuestion(_uiQuestion);
        }
    }

    private void removeQuestionFromForm(UIQuestion _uiQuestion) {
        if (questionsInForm.contains(_uiQuestion)) {
            questionsInForm.remove(_uiQuestion);
            _uiQuestion.resetState();
            uiForm.removeQuestion(_uiQuestion);
        }
    }

    private void addComputedQuestions(Form _form) {
        QLFormDataStorage formDataStorage = new QLFormDataStorage(_form);
        computedQuestions = formDataStorage.getComputedQuestions();
    }

    private void checkComputedQuestions() {
        for (ComputedQuestion computedQuestion : computedQuestions) {
            for (UIQuestion uiQuestion : questionsWithState.keySet()) {
                if (computedQuestion.getIdName().equals(uiQuestion.getId())) {
                    changeSingleComputedQuestion(computedQuestion, uiQuestion);
                }
            }
        }
    }
    
    private void changeSingleComputedQuestion(ComputedQuestion _computedQuestion, UIQuestion _uiQuestion) {
        ExpressionValue result = guiEvaluator.evaluateComputedExpression(_computedQuestion);
        UIComputedQuestion uiComputedQuestion = (UIComputedQuestion) _uiQuestion;
        uiComputedQuestion.setComputedValue(result);
    }

    private void addIfStatementsToQuestion(Form _form) {
        QLFormDataStorage formDataStorage = new QLFormDataStorage(_form);
        List<Question> questionsList = formDataStorage.getAllQuestions();
        List<IfStatement> ifStatementsList = formDataStorage.getIfStatements();

        // Get all the questions of the form.
        for (Question question : questionsList) {
            UIQuestion uiQuestion = createUiQuestion(question);
            valueStorage.saveValue(uiQuestion.getId(), uiQuestion.getState()); // save defaults
            questionsWithState.put(uiQuestion, new ArrayList<IfStatement>());

            // get if statements which the questionsInForm are included.
            for (IfStatement ifStatement : ifStatementsList) {
                if (ifStatement.getBody().contains(question)) {
                    questionsWithState.get(uiQuestion).add(ifStatement);
                }
            }
        }
    }

    private boolean isQuestionStateTrue(UIQuestion _question) {
        boolean isTrue = true;
        for (IfStatement ifStatement : questionsWithState.get(_question)) {
            if (!guiEvaluator.evaluateIfStatement(ifStatement)) {
                isTrue = false;
            }
        }
        return isTrue;
    }

    protected UIQuestion createUiQuestion(Question _question) {
        UIQuestionBuilder typeVisitor = new UIQuestionBuilder(this, valueStorage);
        return _question.accept(typeVisitor);
    }    
}