package org.fugazi.qls.type_checker;

import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor.QuestionsVisitor;
import org.fugazi.qls.ast.widget.Widget;

import java.util.*;

public class QLSTypeChecker {
    private QLFormDataStorage qlFormData;
    private QLSStyleSheetDataStorage qlsStyleSheetData;
    private StyleSheet sheet;
    private QuestionsVisitor questionsVisitor;

    private final ASTIssueHandler astIssueHandler;

    public QLSTypeChecker(StyleSheet _sheet) {
        this.sheet = _sheet;
        this.questionsVisitor = new QuestionsVisitor(this.sheet);

        this.astIssueHandler = new ASTIssueHandler();
    }

    /**
     * =====================
     * Private check methods
     * =====================
     */

    // TODO ABSTRACT OUT INTO ELEMENT IN LIST FROM THE TWO BELOW?
    private void checkForUndefinedQuestions() {
        List<Question> qlQuestions = this.qlFormData.getQuestions();
        List<String> qlQuestionIdNames = new ArrayList<>();

        for (Question question : qlQuestions) {
            qlQuestionIdNames.add(question.getIdName());
        }

        List<org.fugazi.qls.ast.question.Question> qlsQuestions =
                this.qlsStyleSheetData.getQuestions();

        for (org.fugazi.qls.ast.question.Question question : qlsQuestions ) {
            if (!qlQuestionIdNames.contains(question.getId())) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.QLS_ERROR.UNDEFINED, question,
                        "Attempted to define style for an undefined question " + question.getId() + "."
                );
            }
        }
        return;
    }

    private void checkIfAllQuestionsPlaced() {
        List<Question> qlQuestions = this.qlFormData.getQuestions();
        List<org.fugazi.qls.ast.question.Question> qlsQuestions =
                this.qlsStyleSheetData.getQuestions();
        List<String> qlsQuestionIdNames = new ArrayList<>();

        for (org.fugazi.qls.ast.question.Question question : qlsQuestions) {
            qlsQuestionIdNames.add(question.getId());
        }

        for (Question question : qlQuestions ) {
            if (!qlsQuestionIdNames.contains(question.getIdName())) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.QLS_ERROR.MISSING_STYLE, question,
                        "QL Question  " + question.getIdName() + " not placed by QLS sheet and missing style definition."
                );
            }
        }
        return;
    }

    private void checkForMultipleQuestionPlacements() {
        List<org.fugazi.qls.ast.question.Question> qlsQuestions =
                this.qlsStyleSheetData.getQuestions();
        List<String> qlsQuestionIdNames = new ArrayList<>();

        for (org.fugazi.qls.ast.question.Question question : qlsQuestions) {
            if (qlsQuestionIdNames.contains(question.getId())) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.QLS_ERROR.DUPLICATE, question,
                        "QLS Question  " + question.getId() + " already defined (duplicate)."
                );
            } else {
                qlsQuestionIdNames.add(question.getId());
            }
        }
        return;
    }

    private void checkWidgetTypeCompatibility() {
        List<Question> qlQuestions = this.qlFormData.getQuestions();
        List<org.fugazi.qls.ast.question.Question> qlsQuestions =
                this.qlsStyleSheetData.getQuestions();

        HashMap<String, Type> questionTypes = new HashMap<>();
        for (Question question : qlQuestions) {
            questionTypes.put(question.getIdName(), question.getType());
        }

        for (org.fugazi.qls.ast.question.Question question : qlsQuestions) {
            Widget questionWidget = question.getWidget();
            List<Type> supportedQuestionTypes = questionWidget.getSupportedQuestionTypes();
            Type questionType = questionTypes.get(question.getId());

            if (!supportedQuestionTypes.contains(questionType)) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.QLS_ERROR.WRONG_WIDGET_TYPE, question,
                        "Wrong widget " + questionWidget + " for question type "
                            + questionType + "."
                );
            }
        }
        return;

    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */


    public boolean checkStylesheet(StyleSheet _sheet,
                                   QLSStyleSheetDataStorage _qlsSheetData,
                                   QLFormDataStorage _qlFormData) {
        this.sheet = _sheet;
        this.qlsStyleSheetData = _qlsSheetData;
        this.qlFormData = _qlFormData;

        this.checkForUndefinedQuestions();
        this.checkIfAllQuestionsPlaced();
        this.checkForMultipleQuestionPlacements();
        this.checkWidgetTypeCompatibility();

        return this.isFormCorrect();
    }

    public boolean isFormCorrect() {
        return !this.hasErrors();
    }

    public boolean hasErrors() {
        return (this.astIssueHandler.hasErrors());
    }

    public List<ASTNodeIssue> getErrors() {
        List<ASTNodeIssue> errors = this.astIssueHandler.getErrors();

        return errors;
    }

    public List<ASTNodeIssue> getWarnings() {
        List<ASTNodeIssue> warnings = this.astIssueHandler.getWarnings();
        return warnings;
    }
}
