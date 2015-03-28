package org.fugazi.qls.gui;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.GUIEvaluator;
import org.fugazi.ql.gui.UIFormManager;
import org.fugazi.ql.gui.mediator.Colleague;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.ui_elements.UIPanel;
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

import java.util.*;
import java.util.List;

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

    private final Map<UISection, List<UIQuestion>> visibleQuestionsPerSection;
    private final Map<UIQuestion, UISection> parentSections;

    private final Map<UIPage, List<UISection>> visibleSectionsPerPage;
    private final Map<UISection, UIPage> parentPages;

    public StyledGUIBuilder(
            Form _form, 
            QLFormDataStorage _qlData, 
            QLSStyleSheetDataStorage _qlsData,
            WidgetsFactory _widgetFactory) 
    {
        this.valueStorage = new ValueStorage();
        this.guiEvaluator = new GUIEvaluator(valueStorage);

        this.qlsData = _qlsData;
        this.qlData = _qlData;

        this.visibleQuestionsPerSection = new HashMap<>();
        this.parentSections = new HashMap<>();
        this.visibleSectionsPerPage = new HashMap<>();
        this.parentPages = new HashMap<>();

        this.uiFormManager = new QLSUIFormManager(_form.getName());
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
                UISection uiSection = this.parentSections.get(uiQuestion);
                UIPage uiPage = this.parentPages.get(uiSection);

                this.addVisibleQuestionToSection(uiQuestion, uiSection);
                this.addVisibleSectionToPage(uiSection, uiPage);

                this.uiFormManager.addPage(uiPage);
                this.uiFormManager.addSection(uiSection);
                this.uiFormManager.addQuestion(uiQuestion);
            } else {
                UISection parentSection = this.parentSections.get(uiQuestion);
                this.removeVisibleQuestionFromSection(uiQuestion, parentSection);
                this.uiFormManager.removeQuestion(uiQuestion);

                List<UIQuestion> visibleQuestions = this.visibleQuestionsPerSection.get(parentSection);
                if (visibleQuestions != null && visibleQuestions.isEmpty()) {
                    UIPage parentPage = this.parentPages.get(parentSection);
                    this.removeVisibleSectionFromPage(parentSection, parentPage);
                    this.uiFormManager.removeSection(parentSection);
                    List<UISection> visibleSections = this.visibleSectionsPerPage.get(parentPage);

                    if (visibleSections != null && visibleSections.isEmpty()) {
                        this.uiFormManager.removePage(parentPage);
                    }
                }
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

    private void addVisibleQuestionToSection(UIQuestion _uiQuestion, UISection _section) {
        List<UIQuestion> visibleQuestions = this.visibleQuestionsPerSection.get(_section);
        if (visibleQuestions == null) {
            visibleQuestions = new ArrayList<>();
        }
        if (!visibleQuestions.contains(_uiQuestion)) {
            visibleQuestions.add(_uiQuestion);
            this.visibleQuestionsPerSection.put(_section, visibleQuestions);
        }

        return;
    }

    private void removeVisibleQuestionFromSection(UIQuestion _uiQuestion, UISection _section) {
        List<UIQuestion> visibleQuestions = this.visibleQuestionsPerSection.get(_section);
        if (visibleQuestions != null && visibleQuestions.contains(_uiQuestion)) {
            visibleQuestions.remove(_uiQuestion);
            this.visibleQuestionsPerSection.put(_section, visibleQuestions);
        }

        return;
    }

    private void addVisibleSectionToPage(UISection _section, UIPage _uiPage) {
        List<UISection> visibleSections = this.visibleSectionsPerPage.get(_uiPage);
        if (visibleSections == null) {
            visibleSections = new ArrayList<>();
        }
        if (!visibleSections.contains(_section)) {
            visibleSections.add(_section);
            this.visibleSectionsPerPage.put(_uiPage, visibleSections);
        }

        return;
    }

    private void removeVisibleSectionFromPage(UISection _section, UIPage _uiPage) {
        List<UISection> visibleSections = this.visibleSectionsPerPage.get(_uiPage);
        if (visibleSections != null && visibleSections.contains(_section)) {
            visibleSections.remove(_section);
            this.visibleSectionsPerPage.put(_uiPage, visibleSections);
        }
        return;
    }


    private void prepareForm() {
        int pageIndex = 0;
        for (Page page : this.qlsData.getPages()) {
            List<Section> sections = page.getSections();

            UIPage uiPage = new UIPage(page.getName(), pageIndex, sections.size());
            pageIndex++;

            int sectionIndex = 0;
            for (Section section : sections) {
                List<QLSQuestion> questions = section.getQuestions();
                UISection uiSection = new UISection(uiPage, section.getName(), sectionIndex);
                sectionIndex++;

                this.parentPages.put(uiSection, uiPage);

                for (QLSQuestion question : questions) {
                    UIQuestion uiQuestion = this.getUIQuestionById(question.getIdName(), this.questionsWithConditions);
                    this.parentSections.put(uiQuestion, uiSection);
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