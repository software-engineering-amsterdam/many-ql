package org.fugazi.qls.type_checker;

import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.ast.widget.AbstractQLSWidget;
import org.fugazi.qls.ast.widget.widget_types.IWidgetType;
import org.fugazi.qls.ast.widget.widget_types.WidgetTypeToWidgetVisitor;
import org.fugazi.qls.type_checker.issue.ASTQlsNodeIssueType;

import java.util.*;

public class QLSTypeChecker {
    private QLFormDataStorage qlFormData;
    private QLSStyleSheetDataStorage qlsStyleSheetData;

    private final ASTIssueHandler astIssueHandler;

    public QLSTypeChecker(
            QLSStyleSheetDataStorage _qlsSheetData, QLFormDataStorage _qlFormData) 
    {
        this.qlsStyleSheetData = _qlsSheetData;
        this.qlFormData = _qlFormData;
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
        List<QLSQuestion> qlsQuestions = this.qlsStyleSheetData.getQuestions();

        for (QLSQuestion question : qlsQuestions ) {
            if (!qlQuestionIdNames.contains(question.getIdName())) {
                this.astIssueHandler.registerNewError(
                        ASTQlsNodeIssueType.QLS_ERROR.UNDEFINED, question,
                        "Attempted to define style for an undefined question "
                                + question.getIdName() + "."
                );
            }
        }
    }

    private void checkIfAllQuestionsPlaced() {
        List<Question> qlQuestions = this.qlFormData.getAllQuestions();
        List<QLSQuestion> qlsQuestions = this.qlsStyleSheetData.getQuestions();
        List<String> qlsQuestionIdNames = this.getQlsQuestionIdNames(qlsQuestions);

        for (Question question : qlQuestions ) {
            if (!qlsQuestionIdNames.contains(question.getIdName())) {
                this.astIssueHandler.registerNewError(
                        ASTQlsNodeIssueType.QLS_ERROR.MISSING_STYLE, question,
                        "QL Question  " + question.getIdName() +
                                " not placed by QLS sheet and missing style definition."
                );
            }
        }
    }

    private void checkForMultipleQuestionPlacements() {
        List<QLSQuestion> qlsQuestions = this.qlsStyleSheetData.getQuestions();
        List<String> qlsQuestionIdNames = new ArrayList<>();

        for (QLSQuestion question : qlsQuestions) {
            if (qlsQuestionIdNames.contains(question.getIdName())) {
                this.astIssueHandler.registerNewError(
                        ASTQlsNodeIssueType.QLS_ERROR.DUPLICATE, question,
                        "QLS Question  " + question.getIdName() +
                                " already defined (duplicate)."
                );
            } else {
                qlsQuestionIdNames.add(question.getIdName());
            }
        }
    }

    private void checkWidgetTypeCompatibilityInQuestion() {
        List<QLSQuestion> qlsQuestions = this.qlsStyleSheetData.getQuestions();
        HashMap<String, Type> questionTypes = this.qlFormData.getallQuestionTypes();

        for (QLSQuestion question : qlsQuestions) {
            AbstractQLSWidget questionWidget = question.getWidget();
            List<Type> supportedQuestionTypes = questionWidget.getSupportedQuestionTypes();
            Type questionType = questionTypes.get(question.getIdName());

            // if questionType == null that means question is not
            // contained in the qlForm, is reported as QLS_ERROR.UNDEFINED
            if (questionType != null && !supportedQuestionTypes.contains(questionType)) {
                this.astIssueHandler.registerNewError(
                        ASTQlsNodeIssueType.QLS_ERROR.WRONG_WIDGET_TYPE, question,
                        "Wrong widget " + questionWidget + " for question type "
                            + questionType + "."
                );
            }
        }
    }
    
    private void checkWidgetTypeCompatibilityInDeclarations() {
        List<DefaultStyleDeclaration> defaultDeclarations = this.qlsStyleSheetData.getDefaultStyleDeclarations();
        WidgetTypeToWidgetVisitor widgetTypeToWidgetVisitor = new WidgetTypeToWidgetVisitor();
        
        for (DefaultStyleDeclaration defaultStyleDeclaration : defaultDeclarations) {
            IWidgetType widgetType = defaultStyleDeclaration.getWidgetType();
            
            // Convert form type to widget.
            AbstractQLSWidget widget = widgetType.accept(widgetTypeToWidgetVisitor);
            List<Type> supportedWidgetTypes = widget.getSupportedQuestionTypes();
            Type questionType = defaultStyleDeclaration.getQuestionType();

            if (!supportedWidgetTypes.contains(questionType)) {
                this.astIssueHandler.registerNewError(
                        ASTQlsNodeIssueType.QLS_ERROR.WRONG_WIDGET_TYPE, defaultStyleDeclaration,
                        "Wrong widget in Default Style Declaration " + widget
                                + " for question type " + questionType + "."
                );
            }
        }
    }

    /**
     * =====================
     * Helper check methods
     * =====================
     */

    private List<String> getQlQuestionIdNames(List<Question> _qlQuestions) {
        List<String> qlQuestionIdNames = new ArrayList<>();
        for (Question question : _qlQuestions) {
            qlQuestionIdNames.add(question.getIdName());
        }
        return qlQuestionIdNames;
    }

    private List<String> getQlsQuestionIdNames(List<QLSQuestion> _qlsQuestions) {
        List<String> qlsQuestionIdNames = new ArrayList<>();
        for (QLSQuestion question : _qlsQuestions) {
            qlsQuestionIdNames.add(question.getIdName());
        }
        return qlsQuestionIdNames;
    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */

    public boolean checkStylesheet() {
        // clear errors and warnings
        // (so that multiple checks can be performed on one instance)
        this.clearErrorsAndWarnings();

        this.checkForUndefinedQuestions();
        this.checkIfAllQuestionsPlaced();
        this.checkForMultipleQuestionPlacements();
        this.checkWidgetTypeCompatibilityInQuestion();
        this.checkWidgetTypeCompatibilityInDeclarations();

        return this.isFormCorrect();
    }

    public boolean isFormCorrect() {
        return !this.hasErrors();
    }

    public boolean hasErrors() {
        return (this.astIssueHandler.hasErrors());
    }

    public List<ASTNodeIssue> getErrors() {
        return this.astIssueHandler.getErrors();
    }

    public List<ASTNodeIssue> getWarnings() {
        return this.astIssueHandler.getWarnings();
    }

    public void clearErrorsAndWarnings() {
        this.astIssueHandler.clearErrorsAndWarnings();
    }
}