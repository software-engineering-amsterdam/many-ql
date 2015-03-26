package org.fugazi.qls.gui;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.GUIEvaluator;
import org.fugazi.ql.gui.mediator.Colleague;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIComputedQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestionBuilder;
import org.fugazi.ql.gui.widgets.WidgetsFactory;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StyledGUIBuilder implements IMediator {
    private class QuestionsWithConditions extends LinkedHashMap<UIQuestion, List<IfStatement>> {}

    private final ValueStorage valueStorage;
    private final GUIEvaluator guiEvaluator;
    private final QLFormDataStorage qlData;
    private final QLSStyleSheetDataStorage qlsData;

    protected final UIQuestionBuilder uiQuestionBuilder;

    private QuestionsWithConditions questionsWithConditions;
    private List<ComputedQuestion> computedQuestions;

    private final QLSUIFormManager uiFormManager;

    public StyledGUIBuilder(Form _form, QLFormDataStorage _qlData, QLSStyleSheetDataStorage _qlsData, WidgetsFactory _widgetFactory) {
        this.valueStorage = new ValueStorage();
        this.guiEvaluator = new GUIEvaluator(valueStorage);

        this.qlsData = _qlsData;
        this.qlData = _qlData;

        this.uiFormManager = new QLSUIFormManager(_form.getName(), new QLSUIPanel());
        this.uiQuestionBuilder = new UIQuestionBuilder(this, valueStorage, _widgetFactory);

        QLFormDataStorage formDataStorage = new QLFormDataStorage(_form);
        this.questionsWithConditions = this.createQuestionsWithConditions(formDataStorage);
        this.computedQuestions = formDataStorage.getComputedQuestions();

        this.prepareForm();
    }

    public void getChangeFromColleagues(Colleague _origin) {
        this.storeValue(_origin.getId(), _origin.getState());
        this.checkComputedQuestions();
        this.renderUI();
    }

    private void setupForm(Map<UIQuestion, List<IfStatement>> _questionsWithConditionState) {
        if (_questionsWithConditionState == null)
            return;
        
        for (UIQuestion uiQuestion : _questionsWithConditionState.keySet()) {
            if (this.isQuestionStateTrue(_questionsWithConditionState, uiQuestion)) {
                this.uiFormManager.addQuestion(uiQuestion);
            } else {
                this.uiFormManager.removeQuestion(uiQuestion);
            }
        }
    }

    private boolean isQuestionStateTrue(
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

    private void prepareForm() {
        for (Page page : this.qlsData.getPages()) {

            UIPage UIPage = new UIPage(page.getName());
            this.uiFormManager.addPage(UIPage);

            List<Section> sections = page.getSections();
            for (Section section : sections) {
                this.uiFormManager.addSection(new UISection(UIPage, section.getName()));

                List<QLSQuestion> questions = section.getQuestions();
                for (QLSQuestion question : questions) {
                    Question qlQuestion = this.qlData.getQuestionById(question.getIdName());
                    UIQuestion uiQuestion = this.getUIQuestionById(question.getIdName(), this.questionsWithConditions);
                    this.uiFormManager.addQuestion(uiQuestion);
                }
            }
        }
    }

    public void renderUI() {
        this.setupForm(this.questionsWithConditions);
        this.uiFormManager.render();
    }

    private void checkComputedQuestions() {
        if (this.computedQuestions != null) {
            for (ComputedQuestion computedQuestion : this.computedQuestions) {
                this.updateComputedQuestion(computedQuestion);
            }
        }
    }

    private void updateComputedQuestion(ComputedQuestion _computedQuestion) {
        ExpressionValue result = this.guiEvaluator.evaluateComputedExpression(_computedQuestion);
        UIComputedQuestion uiComputedQuestion =
                (UIComputedQuestion) this.getUIQuestionById(_computedQuestion.getIdName(), this.questionsWithConditions);
        uiComputedQuestion.setComputedValue(result);
    }

    protected UIQuestion createUiQuestion(Question _question) {
        return _question.accept(this.uiQuestionBuilder);
    }


    private QuestionsWithConditions createQuestionsWithConditions(QLFormDataStorage _formDataStorage) {
        QuestionsWithConditions questionsWithCondition = new QuestionsWithConditions();

        for (Question question : _formDataStorage.getAllQuestions()) {
            UIQuestion uiQuestion = createUiQuestion(question);
            this.storeValue(uiQuestion.getId(), uiQuestion.getState());
            questionsWithCondition.put(uiQuestion, new ArrayList<>());
            this.addIfStatementsToQuestion(
                    _formDataStorage.getIfStatements(), question, questionsWithCondition);
        }
        return questionsWithCondition;
    }

    private void storeValue(String _id, ExpressionValue _value) {
        this.valueStorage.saveValue(_id, _value);
    }

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

    private UIQuestion getUIQuestionById(
            String _id, QuestionsWithConditions _questionsWithConditions)
    {
        for (UIQuestion uiQuestion : _questionsWithConditions.keySet()) {
            if (_id.equals(uiQuestion.getId())) {
                return uiQuestion;
            }
        }
        return null;
    }

}