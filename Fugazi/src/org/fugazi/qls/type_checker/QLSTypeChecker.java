package org.fugazi.qls.type_checker;

/*
TODO
- no references to questions that are not in the QL program
- all questions of the QL program are placed by the QLS program.
- you cannot place a single question multiple times.
- (default) widget assignments are compatible with question types (e.g. no radio button for integer widgets).
 */

import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor.QuestionsVisitor;

import java.util.ArrayList;
import java.util.List;

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
