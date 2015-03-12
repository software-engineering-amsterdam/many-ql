package org.fugazi.qls.type_checker;

import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.ast.widget.Widget;

import java.util.*;

public class QLSTypeChecker {
    private QLFormDataStorage qlFormData;
    private QLSStyleSheetDataStorage qlsStyleSheetData;

    private final ASTIssueHandler astIssueHandler;

    public QLSTypeChecker() {
        this.astIssueHandler = new ASTIssueHandler();
    }

    /**
     * =====================
     * Private main check methods
     * =====================
     */

    private void checkForUndefinedQuestions() {
        List<Question> qlQuestions = this.qlFormData.getAllQuestions();
        List<String> qlQuestionIdNames = this.getQlQuestionIdNames(qlQuestions);

        List<org.fugazi.qls.ast.question.Question> qlsQuestions =
                this.qlsStyleSheetData.getQuestions();

        for (org.fugazi.qls.ast.question.Question question : qlsQuestions ) {
            if (!qlQuestionIdNames.contains(question.getIdName())) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.QLS_ERROR.UNDEFINED, question,
                        "Attempted to define style for an undefined question "
                                + question.getIdName() + "."
                );
            }
        }
        return;
    }

    private void checkIfAllQuestionsPlaced() {
        List<Question> qlQuestions = this.qlFormData.getAllQuestions();
        List<org.fugazi.qls.ast.question.Question> qlsQuestions =
                this.qlsStyleSheetData.getQuestions();
        List<String> qlsQuestionIdNames = this.getQlsQuestionIdNames(qlsQuestions);

        for (Question question : qlQuestions ) {
            if (!qlsQuestionIdNames.contains(question.getIdName())) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.QLS_ERROR.MISSING_STYLE, question,
                        "QL Question  " + question.getIdName() +
                                " not placed by QLS sheet and missing style definition."
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
            if (qlsQuestionIdNames.contains(question.getIdName())) {
                this.astIssueHandler.registerNewError(
                        ASTNodeIssueType.QLS_ERROR.DUPLICATE, question,
                        "QLS Question  " + question.getIdName() +
                                " already defined (duplicate)."
                );
            } else {
                qlsQuestionIdNames.add(question.getIdName());
            }
        }
        return;
    }

    private void checkWidgetTypeCompatibility() {
        List<Question> qlQuestions = this.qlFormData.getAllQuestions();
        List<org.fugazi.qls.ast.question.Question> qlsQuestions =
                this.qlsStyleSheetData.getQuestions();

//        HashMap<String, Type> questionTypes = this.getQlQuestionType(qlQuestions);
        HashMap<String, Type> questionTypes = this.qlFormData.getallQuestionTypes();

        for (org.fugazi.qls.ast.question.Question question : qlsQuestions) {
            Widget questionWidget = question.getWidget();
            List<Type> supportedQuestionTypes = questionWidget.getSupportedQuestionTypes();
            Type questionType = questionTypes.get(question.getIdName());

            // if questionType == null that means question is not
            // contained in the qlForm, is reported as QLS_ERROR.UNDEFINED
            if (questionType != null && !supportedQuestionTypes.contains(questionType)) {
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
     * Helper check methods
     * =====================
     */

    private List<String> getQlQuestionIdNames(List<Question> qlQuestions) {
        List<String> qlQuestionIdNames = new ArrayList<>();
        for (Question question : qlQuestions) {
            qlQuestionIdNames.add(question.getIdName());
        }
        return qlQuestionIdNames;
    }

    private List<String> getQlsQuestionIdNames(List<org.fugazi.qls.ast.question.Question> qlsQuestions) {
        List<String> qlsQuestionIdNames = new ArrayList<>();
        for (org.fugazi.qls.ast.question.Question question : qlsQuestions) {
            qlsQuestionIdNames.add(question.getIdName());
        }
        return qlsQuestionIdNames;
    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */


    public boolean checkStylesheet(QLSStyleSheetDataStorage _qlsSheetData,
                                   QLFormDataStorage _qlFormData) {
        this.qlsStyleSheetData = _qlsSheetData;
        this.qlFormData = _qlFormData;

        // clear errors and warnings
        // (so that multiple checks can be performed on one instance)
        this.clearErrorsAndWarnings();

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

    public void clearErrorsAndWarnings() {
        this.astIssueHandler.clearErrorsAndWarnings();
    }
}
