package org.fugazi.ql.type_checker;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.form_data.QLFormDataStorage;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.visitor.QLTypeCheckerVisitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

    private void checkDuplicateLabels () {
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

//    private void checkForDuplicateLabels(QLFormDataStorage formData) {
//        List<String> questionLabels = formData.getQuestionLabels();
//    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */

    public boolean checkForm(Form form, QLFormDataStorage formData) {
        this.formData = formData;
        // perform all checks that require storage
        this.checkDuplicateLabels();

        // perform all the checks that can be done on the fly
        form.accept(this.visitor);
        return this.visitor.isFormCorrect();
    }

    public boolean isFormCorrect() {
        return this.visitor.isFormCorrect();
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
