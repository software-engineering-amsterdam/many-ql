package org.fugazi.ql.type_checker;

import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.form_data.QLFormDataStorage;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.fugazi.ql.type_checker.visitor.QLTypeCheckerVisitor;

import java.util.*;


public class QLTypeChecker {
    private final QLTypeCheckerVisitor visitor;
    private final ASTIssueHandler astIssueHandler;

    private QLFormDataStorage formData;

    public QLTypeChecker() {
        this.visitor = new QLTypeCheckerVisitor();
        this.astIssueHandler = new ASTIssueHandler();
    }

    /**
     * =====================
     * Private check methods
     * =====================
     */

    private void checkDuplicateLabels() {
        List<Question> questions = this.formData.getQuestions();
        List<String> labels = new ArrayList<>();

        for (Question question : questions) {
            String label = question.getLabel();

            if (labels.contains(label)) {
                this.astIssueHandler.registerNewWarning(question,
                        "Label defined multiple times! Possible confusion."
                );
            } else {
                labels.add(label);
            }
        }
        return;
    }

    private void checkQuestionTypes() {
        List<Question> questions = this.formData.getQuestions();
        Map<String, Type> questionTypes = new HashMap<>();

        for (Question question : questions) {
            ID questionId = question.getIdentifier();
            Type earlierQuestionType = questionTypes.get(questionId.getName());
            if (earlierQuestionType != null) {
                if (!earlierQuestionType.equals(question.getType())) {
                    this.astIssueHandler.registerNewError(
                            ASTNodeIssueType.ERROR.DUPLICATE,
                            question, "Question already defined with different type."
                    );
                }

            } else {
                questionTypes.put(questionId.getName(), question.getType());
            }

        }

    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */

    public boolean checkForm(Form form, QLFormDataStorage formData) {
        this.formData = formData;
        // perform all checks that require storage
        this.checkDuplicateLabels();
        this.checkQuestionTypes();

        // perform all the checks that can be done on the fly
        form.accept(this.visitor);
        return this.isFormCorrect();
    }

    public boolean isFormCorrect() {
        return (!this.astIssueHandler.hasErrors() && this.visitor.isFormCorrect());
    }

    public List<ASTNodeIssue> getErrors() {
        List<ASTNodeIssue> errors = this.astIssueHandler.getErrors();
        errors.addAll(this.visitor.getErrors());

        return errors;
    }

    public List<ASTNodeIssue> getWarnings() {
        List<ASTNodeIssue> warnings = this.astIssueHandler.getWarnings();
        warnings.addAll(this.visitor.getWarnings());

        return warnings;
    }
}
